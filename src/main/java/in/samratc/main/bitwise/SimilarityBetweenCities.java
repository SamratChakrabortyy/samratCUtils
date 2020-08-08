package in.samratc.main.bitwise;


import java.util.*;

public class SimilarityBetweenCities {
    /**
     * Problem Description
     * <p>
     * You are given a 2-D array A of size N x 2 denoting the list of ( city, visitor ) pairs representing visitors visiting cities.
     * <p>
     * Come up with a program that identifies the pair of two different cities with the greatest similarity.
     * <p>
     * The similarity metric between two different cities x, y is defined as:
     * <p>
     * Let a be the count of common visitors among x, y.
     * Let b be the total number of distinct visitors among x,y i.e. union of visitors of city x and city y.
     * Then Similarity(x, y) = a / b where ('/' implies division operator).
     * NOTE:
     * <p>
     * If suppose two pair of cities (a, b) and (c, d) has same similarity then more priority will be given to the pair which is lexographical. smaller one.
     * A pair (a, b) is lexicographical smaller than pair (c, d) if a < c or if a == c then b < d
     */

    public int[] solve(int[][] a) {
        Map<Integer, Integer> cityVisitor = new HashMap<>();
        for(int[] arr : a){
            int visitor = cityVisitor.getOrDefault(arr[0], 0);
            visitor = visitor | (1 << arr[1]);
            cityVisitor.put(arr[0], visitor);
        }
        //cityVisitor.entrySet().forEach(e -> System.out.println(e.getKey() + " " +  Integer.toBinaryString(e.getValue())));
        double maxSim = -1;
        int[] maxSimPair = new int[2];
        List<Integer> cities = new ArrayList<>(cityVisitor.keySet());
        Collections.sort(cities);
        for(int i = 0; i < cities.size(); i++){
            for(int j = i+1; j < cities.size(); j++){
                double sim = findSimilarity(cityVisitor.get(cities.get(i)), cityVisitor.get(cities.get(j)));
                if(maxSim < sim){
                    maxSimPair = new int[]{cities.get(i), cities.get(j)};
                    maxSim = sim;
                }
            }
        }
        return maxSimPair;
    }

    private double findSimilarity(int city1 , int city2){
        int common = city1 & city2, dist = city1 | city2;
        return (double)Integer.bitCount(common)/ Integer.bitCount(dist);
    }

    //Driver
    public static void main(String... args) {
        int[][] arr = {
                {1, 2},
                {1, 3},
                {1, 5},
                {2, 2},
                {2, 6},
                {2, 9},
                {3, 2},
                {3, 3},
                {3, 5}
        };
        System.out.println(Arrays.toString(new SimilarityBetweenCities().solve(arr)));
    }

}
