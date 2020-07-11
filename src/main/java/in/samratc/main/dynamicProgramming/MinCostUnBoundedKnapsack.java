package in.samratc.main.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class MinCostUnBoundedKnapsack {
    public static void main(String... args){
        System.out.println(new MinCostUnBoundedKnapsackSol().solve(Arrays.asList(2, 3, 1, 5, 4), Arrays.asList(3, 2, 4, 1), Arrays.asList(1, 2, 5, 10)));
    }
}


class MinCostUnBoundedKnapsackSol {
    private static final int INFINITY = (int)1e6;
    public int solve(final List<Integer> capacities, final List<Integer> weights, final List<Integer> costs) {
        return capacities.stream().map(c -> this.minCostUnboundedKnapsack(c, weights, costs)).reduce(Integer::sum).get();
    }

    public int minCostUnboundedKnapsack(int capacity, List<Integer> weights, List<Integer> costs){
        int n = weights.size();
        int[] minCostToFill = new int[capacity + 1];
        Arrays.fill(minCostToFill, INFINITY);
        minCostToFill[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacity; j++){
                if(j >= weights.get(i-1)){
                    minCostToFill[j] = Math.min(minCostToFill[j], minCostToFill[j - weights.get(i-1)] + costs.get(i-1));
                }
            }
        }
        return minCostToFill[capacity];
    }
}