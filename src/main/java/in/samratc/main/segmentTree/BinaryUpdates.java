package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import in.samratc.util.SegmentTree;

public class BinaryUpdates {

	public static void main(String[] args) {
		int[][] b = { { 1,2 }, { 0,2 }, { 1,4 }};
		new BinaryUpdate().solve(4, b);
	}
}

class BinaryUpdate {
	Integer[] segTree;

	public int[] solve(int a, int[][] b) {
		Integer[] arr = new Integer[a];
		Arrays.fill(arr, 1);
		SegmentTree<Integer, Integer> sumTree = new SegmentTree<Integer, Integer>(Integer.class, arr, Integer::sum,
				Function.identity());
		segTree = sumTree.getSegTree();
		int n = b.length;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			switch (b[i][0]) {
			case 0:
				b[i][1]--;
				sumTree.update(b[i][1], 0);
				break;
			case 1:
				if (segTree[1] < b[i][1])
					ans.add(-1);
				else
					ans.add(custumQuery(b[i][1], 1, 0, a - 1) + 1);
				break;
			default:
				break;
			}
		}
		System.out.println(ans);
		return ans.stream().mapToInt(i -> i).toArray();
	}

	private int custumQuery(int q, int treeIndex, int start, int end) {
		if (start == end) {
			if (q == segTree[treeIndex])
				return start;
			else
				return -1;
		}
		int mid = start + (end - start) / 2;
		int left = segTree[2 * treeIndex];
		if (q <= left)
			return custumQuery(q, 2 * treeIndex, start, mid);
		else
			return custumQuery(q - left, 2 * treeIndex + 1, mid + 1, end);
	}
}
