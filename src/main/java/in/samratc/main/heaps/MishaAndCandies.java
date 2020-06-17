package in.samratc.main.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MishaAndCandies {

    public static void main(String... args){
        System.out.println(new MishaAndCandiesSol().solve(new ArrayList<Integer>(Arrays.asList(1,2,1)), 2));
    }

}

class MishaAndCandiesSol{

    public int solve(ArrayList<Integer> candies, int maxCandies) {
        int totalAte = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(candies);
        while(!minHeap.isEmpty()){
            int min = minHeap.remove(), ate = min/2, remaining = min - ate;
            if(min > maxCandies){
                break;
            }
            totalAte += ate;
            if(!minHeap.isEmpty()){
                min = minHeap.remove();
                minHeap.add(min + remaining);
            }
        }
        return totalAte;
    }
}
