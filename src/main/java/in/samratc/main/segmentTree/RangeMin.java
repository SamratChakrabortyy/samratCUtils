package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.function.Function;

import in.samratc.util.SegmentTree;
import in.samratc.util.SegmentTreeOnList;

public class RangeMin {

}

class RangeMinSol {

	public ArrayList<Integer> solve(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> queries) {
		
		SegmentTree<Integer, Integer> rangeMinSegTree = new SegmentTreeOnList<Integer, Integer>(Integer.class, list, Math::min, Function.identity());
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(ArrayList<Integer> q : queries) {
			switch (q.get(0)) {
				case 0:
					rangeMinSegTree.update(q.get(1) - 1, q.get(2));
					break;
				case 1:
					ans.add(rangeMinSegTree.query(q.get(1) - 1, q.get(2) - 1));
					break;
				default:
					break;
			}
		}
		return ans;
	}

}
