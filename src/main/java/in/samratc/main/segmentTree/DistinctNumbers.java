package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import in.samratc.util.SegmentTree;

public class DistinctNumbers {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 4, 2, 1 }, queries[][] = { { 1, 3 }, { 2, 4 }, { 1, 5 } };
		System.out.println(Arrays.toString(new DistinctNumbersSol().solve(arr, queries)));

	}

}

class DistinctNumbersSol {

	public int[] solve(int[] arr, int[][] queries) {

		// Null check
		if (arr == null || queries == null)
			return arr;
		// Creating ans array
		int[] ans = {};

		int n = queries.length, m = arr.length;

		// If No queries are present return blank ans
		if (n == 0)
			return ans;

		ans = new int[n];

		// if no elements are present return 0 distinct elements for all the queries
		if (m == 0)
			return ans;

		// Create a HashMap with key as the R of the query [L, R] while the value as the
		// index in the queries array
		Map<Integer, List<Integer>> queryMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!queryMap.containsKey(queries[i][1] - 1))
				queryMap.put(queries[i][1] - 1, new ArrayList<Integer>());
			queryMap.get(queries[i][1] - 1).add(i);
		}

		// Creating lastSeenMap of the array elements
		Map<Integer, Integer> lastseen = new HashMap<>();

		// Create a uniqueness array and build a rangeSum Segment tree over it
		Integer[] uniqIntegers = new Integer[m];
		Arrays.fill(uniqIntegers, 0);

		SegmentTree<Integer, Integer> rangeSumSegmentTree = new SegmentTree<Integer, Integer>(Integer.class,
				uniqIntegers, Integer::sum, Function.identity());

		// Answering the queries
		for (int i = 0; i < m; i++) {

			// update lastseen and segment Tree
			int last = -1;
			if (lastseen.containsKey(arr[i]))
				last = lastseen.get(arr[i]);
			if (last != -1)
				rangeSumSegmentTree.update(last, 0);
			lastseen.put(arr[i], i);
			rangeSumSegmentTree.update(i, 1);

			// Answer queries ending at pos i;
			if(queryMap.containsKey(i)) {
				for (int q : queryMap.get(i)) {
					ans[q] = rangeSumSegmentTree.query(queries[q][0] - 1, queries[q][1] - 1);
				}				
			}
		}

		return ans;
	}
}
