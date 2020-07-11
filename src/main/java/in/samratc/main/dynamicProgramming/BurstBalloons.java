package in.samratc.main.dynamicProgramming;

import java.util.stream.IntStream;

public class BurstBalloons {
}

class BurstBalloonsSol {
    public int solve(int[] coins){
        int n = coins.length;
        if(n == 1)
            return coins[0];
        int[][] mul= new int[n][n];
        IntStream.range(0, n).forEach(i-> mul[i][i] = i);
        for(int i = 0; i < n-1 ; i++)
            mul[i+1][i] = mul[i][i + 1] = coins[i] * coins[i + 1];
        return  0;
    }
}
