package in.samratc.main.topInterviewQuesLeetcode;

import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/
public class PerfectSquare {
    /*
            Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
            which sum to n.
     */
    public int numSquares(int n) {
        int[] count = new int[n+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0]  = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                count[i] = Math.min(count[i], count[i - j*j] + 1);
            }
        }
        return count[n];
    }
}
