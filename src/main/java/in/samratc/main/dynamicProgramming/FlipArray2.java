package in.samratc.main.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class FlipArray {
    public static void main(String... args){
        System.out.println(new FlipArraySol().solve(Arrays.asList(14, 10, 4)));
    }
}

class FlipArraySol {
    public int solve(final List<Integer> list) {
        int n = list.size();
        int totalSum = list.stream().reduce(Integer::sum).get();
        /*
         poss[i][j] = true if it's possible to create a sum of 'j' using first 'i' values of the list;
         for each i there are two options:
            1. don't take it:  In this case poss[i][j] = poss[i-1][j]
            2. take i'th value: In this case poss[i][j] = poss[i-1][j-list[i]]

         Therefore poss[i][j] is either the value after considering the i'th value in the sum 'OR' the sum without the i'th value
              => pos[i][j] = pos[i-1][j] || pos[i-1][j-list[i]]

          #> base case: poss[0][0] = true as it's possible to create a sum of 0 using 0 values of the list


          Notice that we  are just using the last row to calculate the value pof the present row..
          So this can be done using 2 * totalSum size of array even totalSum size.
       */
        boolean[][] poss = new boolean[n+1][totalSum+1];
        Arrays.fill(poss[0] , true);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= totalSum; j++){
                poss[i][j] = poss[i-1][j];
                if(j >= list.get(i-1))
                  poss[i][j] = poss[i][j] || poss[i-1][j - list.get(i-1)];
            }
        }
        for(int i = totalSum/2; i >= 0; i++){
            if(poss[n][i])
                return totalSum - 2*i;
        }
        return totalSum;
    }
}
