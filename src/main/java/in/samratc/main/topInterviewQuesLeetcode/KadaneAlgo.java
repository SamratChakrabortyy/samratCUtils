package in.samratc.main.topInterviewQuesLeetcode;

// https://leetcode.com/problems/maximum-subarray/
public class KadaneAlgo {
    /**
     *  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, max = 0;
        for(int i = 0; i < nums.length ; i++){
            max += nums[i];
            maxSum = Math.max(maxSum, max);
            max = Math.max(0, max);
        }
        return maxSum;
    }
}
