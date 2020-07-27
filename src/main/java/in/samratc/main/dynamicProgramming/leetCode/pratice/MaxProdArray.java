package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class MaxProdArray {
    public int maxProduct(int[] nums) {
        int globalMax = Integer.MIN_VALUE, maxEndingHere = 1, minEndingHere = 1;
        for(int num : nums){
            int tempMax = Math.max(num, Math.max(maxEndingHere * num, minEndingHere * num));
            minEndingHere = Math.min(num, Math.min(maxEndingHere * num, minEndingHere * num));
            maxEndingHere = tempMax;
            globalMax = Math.max(globalMax, maxEndingHere);
        }
        return globalMax;
    }
}