package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnBoundedKnapsack {
    public static void main(String... args){
        System.out.println(new UnBoundedKnapsackSol().solve(10, Arrays.asList(6,7), Arrays.asList(5,5)));
    }
}

class UnBoundedKnapsackSol {
    public int solve(int capacity, List<Integer> values, List<Integer> weights) {
        int n = values.size();
        int[] profitForCapacity = new int[capacity+1];
        /*
            For each value of I the profitForCapacity denotes the max profit for that many items from the start under that weight
            At first the array denotes the maxProfit that can be achieved using 0 items that will be '0'
            So the whole array before start of the loop is 0
        */
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                if(weights.get(i-1) <= j){
                    profitForCapacity[j] = Math.max(profitForCapacity[j], profitForCapacity[j - weights.get(i-1)] + values.get(i-1));
                }
            }
        }
        return profitForCapacity[capacity];
    }


}


