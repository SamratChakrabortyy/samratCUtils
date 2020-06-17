package in.samratc.main.segmentTree;

import java.util.ArrayList;

import in.samratc.util.SegmentTreeOnArray;

public class PrimeInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PrimeInRangeSol {

	public ArrayList<Integer> solve(ArrayList<Integer> list, ArrayList<String> q, ArrayList<Integer> x,
			ArrayList<Integer> y) {

		Integer[] arr = list.stream().toArray(Integer[]::new);
		SegmentTreeOnArray<Integer, Integer> raneSumSegTree = new SegmentTreeOnArray<Integer, Integer>(Integer.class, arr,
				Integer::sum, this::checkPrime);
		int n = q.size();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			switch (q.get(i)) {
				case "C":
					raneSumSegTree.update(x.get(i) - 1, y.get(i));
					break;
				case "A":
					ans.add(raneSumSegTree.query(x.get(i) - 1, y.get(i) - 1));
					break;
				default:
					break;
			}
		}
		return ans;
	}

	private Integer checkPrime(Integer num) {
		if (num < 2)
			return 0;
		if (num == 2)
			return 1;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++)
			if (num % i == 0)
				return 0;
		return 1;
	}

}
