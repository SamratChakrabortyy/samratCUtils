package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class BurstBalloons {
}

class BurstBalloonsSol {
    public int solve(ArrayList<Integer> coins) {
        if(coins == null || coins.size() == 0)
            return 0;
        //Adding 1 at first and the last
        coins.add(0, 1);
        coins.add(1);
        int n = coins.size();
        //mul[i][j] denotes the max coins if there were balloons only from i-j
        int[][] mul = new int[n][n];

        for(int i = 1; i < n-1; i++)
            mul[i][i+1] = coins.get(i-1)*coins.get(i)*coins.get(i+1);

        for(int l = 3 ; l < n ; l++){
            for(int i = 1; i + l - 1<= n; i++){
                int j = i+l-1;
                mul[i][j] = 0;
                for(int k = i; k <= j; k++){
                    mul[i][j] = Math.max(mul[i][j] , coins.get(i-1) * coins.get(k)* coins.get(j) + mul[i][k] + mul[k+1][j]);
                }
            }
        }
        return mul[1][n-1];
    }
}
