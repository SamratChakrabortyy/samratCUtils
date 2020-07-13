package in.samratc.main.topInterviewQuesLeetcode;

public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will
     * automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
     * you can rob tonight without alerting the police.
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int excl = 0, incl = 0;
        for(int num : nums){
            int temp = incl;
            incl = Math.max(excl + num, incl);
            excl = temp;
        }
        return Math.max(incl, excl);
    }
    /*
            2 1 1 6 8 10
            incl = 0    2   2   3   8   11  18
            excl = 0    0   2   2   3   8
     */
}
