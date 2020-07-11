package in.samratc.main.dynamicProgramming;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.WeakHashMap;

/*
        Problem https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
        Approach : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/solution/

*/
public class ArithmeticSubsequencesCount {
    public static void main(String... args) {
        int[] arr = {-540, -616, 278, 862, -440, 714, 590, 598, 50, 233, -760, -171, -507, -21, 853, -610, 201, 980, 720, 270, 665, 66, -6, -988, -765, -84, -757, -695, -999, 273, -601, -982, 215, 678, 438, 332, 391, 27, -514, 998, 817, -274, -617, -691, 262, 794, -301, -538, 773, 977, 732, 437, 42, -717, 6, 277, 199, 249, 139, -243, -921, 539, -667, -149, -227, 771, 740, -837, -646, -775, 718, -829, -48, -900, -520, -787, 451, -263, -767, 223, -287, 965, -784, 755, -753, 223, -412, 4, -972, 728, 318, 665, -177, 651, -928, 596, -22, 812, 316, 333};
        System.out.println(new ArithmeticSubsequencesCountSol().solve(arr));
    }
}

class ArithmeticSubsequencesCountSol {
    public int solve(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer>[] counts= new Map[n];
        for(int i = 0; i < n; i++){
            counts[i] = new WeakHashMap<>();
            for(int j = 0; j < i; j++){
                long delta = (long)nums[i] - (long)nums[j];
                if(delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE)
                    continue;
                int diff = (int)delta;
                int countj = counts[j].getOrDefault(diff, 0);
                int counti = counts[i].getOrDefault(diff, 0);
                counts[i].put(diff, counti + countj + 1);
                ans += countj;
            }
        }
        return  ans;
    }
}
