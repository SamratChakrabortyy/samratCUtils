package in.samratc.main.heaps;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class temp {

    public static void main(String... args){
        System.out.println(new Solution().solve(new ArrayList<>(Arrays.asList(1,2,3,4)), 3));
    }

}

class Solution {
    public int solve(ArrayList<Integer> list, int b) {
        List<Pair<Integer, Integer>> pairList = list.stream().map(i -> new Pair<Integer, Integer>(i,i,this::comparePair)).collect(Collectors.toList());
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(pairList);
        while(b-- > 0){
            Pair<Integer, Integer> min = minHeap.remove();
            min = new Pair<>(min.val1 + min.val2 , min.val2, this::comparePair);
            minHeap.add(min);
        }
        return minHeap.stream().max((p,q) -> Integer.compare(p.val1, q.val1)).get().val1;
    }

    private int comparePair(Pair<Integer, Integer> p, Pair<Integer, Integer> q){
        return Long.compare((long)p.val1+p.val2 , (long)q.val2+q.val1);
    }
}

class Pair<E,F> implements Comparable<Pair<E, F>>{
    public E val1;
    public F val2;
    Comparator<Pair<E,F>> comparator;

    public Pair(E x, F y){
        val1=x;
        val2=y;
    }

    public Pair(E x, F y, Comparator<Pair<E,F>> comparator){
        val1=x;
        val2=y;
        this.comparator = comparator;
    }

    public String toString(){
        return String.format("(%s, %s)",val1, val2);
    }

    public int compareTo(Pair<E, F> p){
        if(comparator == null){
            return Integer.compare(this.hashCode(), p.hashCode());
        }
        return comparator.compare(this, p);
    }

}

//  10, 14,

