package in.samratc.main;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import in.samratc.util.SegmentTree;

public class Main {

	public static void main(String[] args) {
		// Building a Segment Tree for min in range for Integers		
		
		  Integer[] arr = {-1,2,6,8,-3,9,12,-7,16,5}; SegmentTree<Integer, Integer>
		  minSegTree = new SegmentTree<Integer, Integer>(Integer.class, arr, Math::min,
		  Function.identity()); minSegTree.print();
		 
		
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
