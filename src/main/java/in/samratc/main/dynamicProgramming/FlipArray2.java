package in.samratc.main.dynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FlipArray2 {
    public static void main(String... args) {
        System.out.println(new FlipArray2Sol().solve(Arrays.asList(8, 4, 5, 7, 6, 2)));
    }
}

class FlipArray2Sol {
    private static final int INFINITY = 200000;
    public int solve(final List<Integer> list) {

        int n = list.size();
        int totalSum = list.stream().reduce(Integer::sum).get();
            /*
             count[i][j] = min number of numbers needed to be flipped to create a sum of 'j' using first 'i' values of the list;
             for each i there are two options:
                1. don't take it:  In this case count[i][j] = count[i-1][j]
                2. take i'th value: In this case count[i][j] = count[i-1][j-list[i]] + 1

             Therefore count[i][j] is either the value after considering the i'th value in the sum 'OR' the sum without the i'th value
                  => count[i][j] = min(count[i-1][j], count[i-1][j-list[i]] + 1)

              #> base case: count[0][0] = 0 as  to create a sum of 0 using 0 values of the list we need to flip 0 numbers
              There's no way of forming any other sum using 0 elements to
              for s in  [1 to totalSum]
                   count[0][s] = INFINITY


              Notice that we  are just using the last row to calculate the value pof the present row..
              So this can be done using 2 * totalSum size of array even totalSum size.
           */
        int[][] count = new int[n + 1][totalSum + 1];
        count[0][0] = 0;
        IntStream.range(1, totalSum + 1).forEach(i -> count[0][i] = INFINITY);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                count[i][j] = count[i - 1][j];
                if (j >= list.get(i - 1))
                    count[i][j] = Math.min(count[i][j], 1 + count[i - 1][j - list.get(i - 1)]);
            }
        }
        for (int i = totalSum / 2; i >= 0; i--) {
            if (count[n][i] < INFINITY)
                return count[n][i];
        }
        return Integer.MAX_VALUE;

    }
}
