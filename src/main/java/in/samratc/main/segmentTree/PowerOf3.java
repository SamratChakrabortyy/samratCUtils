package in.samratc.main.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import in.samratc.util.SegmentTreeOnArray;

public class PowerOf3 {

	public static void main(String[] args) {
			int[][] queries = {  {0, 3, 5},
			        {0, 3, 4},
			        {1, 2, -1},
			        {0, 1, 5},
			     };
			List<List<Integer>> queryList = new ArrayList<>();
			for(int[] q : queries) {
				List<Integer> temp = Arrays.stream(q).boxed().collect(Collectors.toList());
				queryList.add(temp);
			}
			System.out.println(new PowerOf3Sol().solve("10010", queryList));
	
	}

}

class PowerOf3Sol {

	public ArrayList<Integer> solve(String str, List<List<Integer>> queries) {
		
		int n = str.length();
		
		Integer[][] arr = new Integer[n][2];
		for(int i = 0; i < n; i++) {
			Integer[] temp = new Integer[2];
			temp[0] = (int) (str.charAt(i) - '0');
			temp[1] = 1;
			arr[i] = temp;
		}
		
		SegmentTreeOnArray<Integer[], Integer[]>  mod3SegTree = new SegmentTreeOnArray<Integer[], Integer[]>(Integer[].class, arr, this::concatMod, Function.identity());
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(List<Integer> q : queries) {
			switch (q.get(0)) {
				case 1:
					int idx = q.get(1) - 1;
					if(arr[idx][0] == 0) {
						Integer[] temp = new Integer[2];
						temp[0] = 1;
						temp[1] = 1;
						mod3SegTree.update(idx, temp);
					}
					ans.add(-1);
					break;
				case 0:
					int l = q.get(1) - 1, r = q.get(2) - 1;
					ans.add(mod3SegTree.query(l, r)[0]);
					break;
				default:
					break;
			}
			Arrays.stream(arr).forEach(a-> System.out.print(Arrays.toString(a)));
			System.out.println();
		}
		return ans;
	}
	
	private Integer[] concatMod(Integer[] left, Integer[] right) {
		Integer[] ans = new Integer[2];
		
		/* 
		 *   Integer.parseInt(left.append(right)) % 3 
		 * = (left * 2^(len(right)) + right) % 3
		 * = ((left % 3) * (2^len(right) % 3) + right % 3) % 3
		 *  
		 *  
		 *  Notice 2^X % 3 = 1 if X is even
		 *                 = 2 if X is Odd
		 * 
		 * */
		
		if(right[1] % 2 == 0)
			ans[0] = (left[0] + right[0]) % 3;
		else
			ans[0] = (left[0]*2 + right[0]) % 3;
		ans[1] = left[1] + right[1];
		return ans;
	}
	
}