package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import in.samratc.util.SegmentTree;

public class SpecialSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 1, 8, 5, 5, 3, 1 }, queries[][] = { { 1, 5, 1 }, { 1, 4, 6 }, { 1, 7, 10 }, { 2, 2, 3 },
				{ 1, 3, 9 }, { 1, 1, 7 }, { 1, 4, 2 }, { 1, 4, 3 }, { 2, 5, 6 }, { 2, 2, 3 }, };
		System.out.println(Arrays.toString(new SpecialSum2Sol().solve(arr, queries)));
	}

}

/*
 * SplSum(L,R) = arr[L] + 2 * arr[L+1} + 3 * arr[L+2] + .... + (R - L + 1) *
 * arr[R] => SplSum(L,R) = Sum(i-> L,R)((i-L+1)*arr[i]) => SplSum(L,R) = Sum(i->
 * L,R)(i*arr[i] - (L-1)*arr[i]) => SplSum(L,R) = Sum(i-> L,R)(i*arr[i]) -
 * Sum(i-> L,R)((L-1)*arr[i])
 * 
 */

class SpecialSum2Sol {

	long mod = 1000000007L;

	public int[] solve(int[] a, int[][] queries) {
		int n = a.length;
		Long[][] arr = new Long[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = (long) a[i];
			arr[i][1] = (long) (i + 1) * a[i];
		}
		ArrayList<Integer> sums = new ArrayList<Integer>();
		SegmentTree<Long[], Long[]> rangeSumSegTree = new SegmentTree<Long[], Long[]>(Long[].class, arr, this::modSum,
				Function.identity());

		n = queries.length;

		for (int i = 0; i < n; i++) {
			switch (queries[i][0]) {
			case 1:
				int pos = queries[i][1] - 1, val = queries[i][2];
				Long[] temp = new Long[2];
				temp[0] = (long) val;
				temp[1] = (long) (pos + 1) * val;
				rangeSumSegTree.update(pos, temp);
				break;
			case 2:
				int l = queries[i][1] - 1, r = queries[i][2] - 1;
				Long q[] = rangeSumSegTree.query(l, r);
				sums.add((int) ((q[1] - (((l) * q[0]) % mod) + mod) % mod));
				break;
			default:
				break;
			}
		}
		return sums.stream().mapToInt(i -> i).toArray();
	}

	private Long[] modSum(Long[] a, Long[] b) {
		Long[] temp = new Long[2];
		temp[0] = (a[0] + b[0]) % mod;
		temp[1] = (a[1] + b[1]) % mod;
		return temp;
	}

}
