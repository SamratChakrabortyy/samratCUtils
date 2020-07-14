package in.samratc.main.topInterviewQuesLeetcode;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
    private static final int INFINITY = (int)1e7;
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;
        int[] count = new int[amount+1];
        Arrays.fill(count, INFINITY);
        count[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i)
                    count[i] = Math.min(count[i], count[i - coin] + 1);
            }
        }
        return count[amount] >= INFINITY ? -1 : count[amount];
    }
}

