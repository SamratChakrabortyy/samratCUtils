package in.samratc.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import in.samratc.util.SegmentTree;

public class Main {

	public static void main(String[] args) {
		/*
		int[][] b = {
				  {1, 11, -1},
				  {1, 12, -1},
				  {1, 7, -1},
				  {3, 2, 7},
				  {3, 4, 8},
				  {2, 13, -1},
				  {1, 10, -1},
				  {1, 1, -1},
				  {2, 3, -1},
				  {1, 7, -1},
				  {3, 8, 10},
				  {2, 1, -1},
				  {2, 6, -1},
				  {2, 2, -1},
				  {2, 8, -1},
				  {1, 6, -1},
				  {1, 4, -1},
				  {2, 1, -1},
				  {3, 1, 7},
				  {1, 13, -1},
				  {3, 1, 10},
				  {2, 6, -1},
				  {3, 3, 12},
				  {3, 5, 10},
				  {3, 3, 6},
				  {1, 1, -1},
				  {2, 1, -1},
				  {2, 1, -1},
				  {3, 4, 12},
				  {3, 2, 5},
				};
		new Solution().solve(13, b);
		*/
		
		//Building segment tree for Strings where each of the tree nodes contain the charSet for vowels

		String[] arr2 = {"ab", "bc", "de", "ef", "ij", "kl", "ou"};
		SegmentTree<String, Set> vowelSegTree = new SegmentTree<>(Set.class, arr2, Main::charSetMerger, Main::getVowels);
		vowelSegTree.print();
	}

	
	private static Set<Character> charSetMerger(Set<Character> set1, Set<Character> set2){
		Set<Character> ans= new HashSet<>();
		ans.addAll(set1);
		ans.addAll(set2);
		return ans;
	}
	
	private static Set<Character> getVowels(String str){
		return str.chars().mapToObj(c -> (char)c).filter(c -> {return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';}).collect(Collectors.toSet());
	}
}


class Solution{
	public int[] solve(int n, int[][] b) {
        Integer[] arr = new Integer[n];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(arr,0);
        SegmentTree<Integer,Integer> sumSegTree = new SegmentTree<>(Integer.class, arr, Integer::sum, Function.identity());
        n = b.length;
        for(int i = 0; i < n; i++){
        	b[i][1]--;
        	b[i][2]--;
            switch (b[i][0]) {
				case 1:
					sumSegTree.update(b[i][1],arr[b[i][1]]+1);
					break;
				case 2:
					if(arr[b[i][1]] > 0)
	            		sumSegTree.update(b[i][1],arr[b[i][1]]-1);
					break;
				case 3:
					ans.add(sumSegTree.query(Math.min(b[i][1],b[i][2]), Math.max(b[i][1],b[i][2])));
					break;
				default:
					break;
			}
        }
        System.out.println(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
}