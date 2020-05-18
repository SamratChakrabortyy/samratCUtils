package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import in.samratc.util.SegmentTree;

public class SpecialSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 1, 4, 3}, queries[][] = { {1, 1, 3}, {1, 2, 5}, {1, 1, 3}, { 1, 2, 4 } };
		System.out.println(Arrays.toString(new SpecialSumSol().solve(arr, queries)));
	}

}

/*
 * SplSum(L,R) = arr[L] + 2 * arr[L+1} + 3 * arr[L+2] + .... + (R - L + 1) *
 * arr[R] => SplSum(L,R) = Sum(i-> L,R)((i-L+1)*arr[i]) => SplSum(L,R) = Sum(i->
 * L,R)(i*arr[i] - (L-1)*arr[i]) => SplSum(L,R) = Sum(i-> L,R)(i*arr[i]) -
 * Sum(i-> L,R)((L-1)*arr[i])
 * 
 */

class SpecialSumSol {

	long mod = 100000007L;

	public int[] solve(int[] arr, int[][] queries) {
		// Null check
		if (arr == null || queries == null)
			return arr;
		int n = arr.length, m = queries.length;
		int[] ans = {};
		/*
		// No. of queries is 0
		if (m == 0)
			return ans;
		// Initializing ans;
		ans = new int[m];
		// No numbers in array
		if (n == 0)
			return ans;
		*/
		List<Integer> temp = new ArrayList<Integer>();

		// Mapping arr to obj and creating a rangeSum segment tree fro a[i]
		Long[] a = Arrays.stream(arr).mapToLong(i -> (long) i).boxed().toArray(Long[]::new);
		SegmentTree<Long, Long> rangeSumTreeA = new SegmentTree<>(Long.class, a, this::modSum, Function.identity());

		Long[] b = IntStream.range(0, n).mapToLong(i -> (long) ((i + 1) * arr[i])).boxed().toArray(Long[]::new);
		SegmentTree<Long, Long> rangeSumTreeB = new SegmentTree<>(Long.class, b, this::modSum, Function.identity());

		for (int i = 0; i < m; i++) {
            switch (queries[i][0]) {
				case 1:
					int pos = queries[i][1] - 1, val = queries[i][2];
					rangeSumTreeA.update(pos, new Long(val));
					rangeSumTreeB.update(pos, new Long((pos+1)*val));					
					break;
				case 2:
					int l = queries[i][1] - 1, r = queries[i][2] - 1;
					long sumB = rangeSumTreeB.query(l, r) % mod, sumA = rangeSumTreeA.query(l, r) % mod;
					long splSum = (sumB - ((l * sumA) % mod) + mod) % mod;
					temp.add((int) (splSum));
					break;
				default:
					break;
			}
        }
		return temp.stream().mapToInt(i -> i).toArray();
	}
	
	private Long modSum(Long a, Long b) {
		return ((a % mod) + (b % mod)) % mod;
	}

}
