package in.samratc.main.topInterviewQuesLeetcode;

public class ClimbingStairs {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public int climbStairs(int n) {
        int[] ways = new int[2];
        //Base case
        ways[0] = ways[1] = 1;
        for (int i = 2; i <= n; i++)
            ways[i % 2] = ways[(i - 2) % 2] + ways[(i - 1) % 2];
        return ways[n % 2];
    }
}
