package in.samratc.main.dynamicProgramming;

public class PickFromBothSides {
    /**
     * Given an integer array nums of size N.
     * You can pick k elements from either left or right end of the array nums to get maximum sum.
     * Find and return this maximum possible sum.
     * <p>
     * NOTE: Suppose k = 4 and array nums contains 10 elements then:
     * You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc .
     * You need to return the maximum possible sum of elements you can pick.
     */
    public int solve(int[] nums, int k) {
        /*
                At first it looks like a Greedy problem that we can just pick the largest ones and sum them.
                But think of the example nums = {7, 5, 4, 4 100, -1} and k = 2 Greedy will lead to an answer of 12 (7 + 5) but the answer is 99 (100 + (-1))

                The second thing after greedy which comes to mid is DP which can be easily formed by the recursive eq :
                        maxSum(num, 0, N, k) = max((nums[0] + maxSum(nums, 1, N, k-1)), (nums[N] + maxSum(nums, 0, N - 1, k-1));

                 Though it looks like a 3D DP but if you look closely it is not as start, end and length are interdependent variables
                 i.e for start = i and len = k - x it is evident that we have already chosen i-1 elements form left and x-i-1 elements from right
                 Therefore end = N - (x - i - 1)

                 So, its evidently a 2D DP so the no. of states = N^2

                 But if you look closely you'll find out that we can solve this O(k) for  time and O(1) space.
                 See the code ;)  (PS this is discussed not my own, LOL)
         */
        if (nums == null || nums.length == 0 || k <= 0)
            return 0;
        int n = nums.length;
        int prefixSum = 0;
        for (int i = 0; i < k; i++) {
            prefixSum = prefixSum + nums[i];
        }
        int max = prefixSum, suffixSum = 0;
        for (int i = 0; i < k; i++) {
            suffixSum += nums[n-1-i];
            prefixSum -= nums[k-1-i];
            max = Math.max(max, suffixSum + prefixSum);
        }
        return max;
    }

    //Driver
    public static void main(String... args){
        PickFromBothSides bs = new PickFromBothSides();
        System.out.println(bs.solve(new int[]{7, 5, 4, 4, 100, -1}, 1));
        System.out.println(bs.solve(new int[]{7, 5, 4, 4, 100, -1}, 2));
    }
}
