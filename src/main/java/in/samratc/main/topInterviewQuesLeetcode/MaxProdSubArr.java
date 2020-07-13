package in.samratc.main.topInterviewQuesLeetcode;

public class MaxProdSubArr {
    /**
     * Given an integer array nums, find the contiguous subArray within an array
     * (containing at least one number) which has the largest product.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int globalMax = Integer.MIN_VALUE, currMax = 1, currMin = 1;
        for (int num : nums) {
            currMax *= num;
            currMin *= num;
            int temp = Math.max(currMax, Math.max(currMin, num));
            currMin = Math.min(currMax, Math.min(currMin, num));
            currMax = temp;
            globalMax = Math.max(globalMax, currMax);
            //System.out.println(String.format("%d %d %d", currMax, currMin, globalMax));
        }
        return globalMax;
    }
}
