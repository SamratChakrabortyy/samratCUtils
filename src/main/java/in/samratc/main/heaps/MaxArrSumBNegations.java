package in.samratc.main.heaps;

import in.samratc.util.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxArrSumBNegations {

	public static void main(String[] args) {
		System.out.println(new MaxArrSumBNegationsSol().solve(new ArrayList<Integer>(Arrays.asList(24, -68, -29, -9, 84)), 4));
		System.out.println("\n\n");
		System.out.println(new MaxArrSumBNegationsSol2().solve(new ArrayList<Integer>(Arrays.asList(24, -68, -29, -9, 84)), 4));
	}

}

class MaxArrSumBNegationsSol {

	public int solve(ArrayList<Integer> nums, int b) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>(nums);
		System.out.println(minheap);
		//minheap.addAll(nums);
		while(b-- > 0) {
			//System.out.println(minheap);
			int min = minheap.remove();
			minheap.add(-1*min);
		}
		return minheap.stream().reduce(Integer::sum).get();
	}

}

class MaxArrSumBNegationsSol2{

	public int solve(ArrayList<Integer> nums, int b) {
		Heap<Integer> minheap = new Heap<>(nums, Integer::compare);
		//minheap.addAll(nums);
		System.out.println(minheap);
		while(b-- > 0) {
			//System.out.println(minheap);
			int min = minheap.removeRoot();
			minheap.insert(-1*min);
		}
		return minheap.stream().reduce(Integer::sum).get();
	}

}
