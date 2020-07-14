package in.samratc.main.topInterviewQuesLeetcode;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] subSeq = new int[nums.length];
        int lst = 0;
        for (int num : nums) {
            int pos = Arrays.binarySearch(subSeq, 0, lst, num);
            pos = pos < 0 ? ~pos : pos;
            subSeq[pos] = num;
            if (lst == pos)
                lst++;
        }
        return lst;
    }
}
