package in.samratc.main.dynamicProgramming;

import java.util.*;
import java.util.stream.IntStream;

/*
        Problem https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
        Approach : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/solution/

*/
public class ArithmeticSubsequencesCount {
    public static void main(String... args) {
        //int[] arr = {-540, -616, 278, 862, -440, 714, 590, 598, 50, 233, -760, -171, -507, -21, 853, -610, 201, 980, 720, 270, 665, 66, -6, -988, -765, -84, -757, -695, -999, 273, -601, -982, 215, 678, 438, 332, 391, 27, -514, 998, 817, -274, -617, -691, 262, 794, -301, -538, 773, 977, 732, 437, 42, -717, 6, 277, 199, 249, 139, -243, -921, 539, -667, -149, -227, 771, 740, -837, -646, -775, 718, -829, -48, -900, -520, -787, 451, -263, -767, 223, -287, 965, -784, 755, -753, 223, -412, 4, -972, 728, 318, 665, -177, 651, -928, 596, -22, 812, 316, 333};
        int[] arr = {-4, 5, 4, 0, 5, 9, 3, 4, 0, -3};
                System.out.println(new ArithmeticSubsequencesCountSol2().solve(arr));
    }
}

class ArithmeticSubsequencesCountSol {
    public int solve(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer>[] counts= new Map[n];
        for(int i = 0; i < n; i++){
            counts[i] = new HashMap<>();
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


class ArithmeticSubsequencesCountSol2 {
    public int solve(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        int n = nums.length, count = 0;
        Map<Integer, Integer>[] countMap = new Map[n];
        IntStream.range(0, n).forEach(i-> countMap[i] = new HashMap<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                long delta = nums[i] - nums[j];
                if(delta > Integer.MAX_VALUE || delta < Integer.MIN_VALUE)
                    continue;
                int diff = (int)delta;
                int countj = countMap[j].getOrDefault(diff, 0);
                int counti = countMap[i].getOrDefault(diff, 0);
                countMap[i].put(diff, counti + countj + 1);
                count += countj;
            }
        }
        Arrays.stream(countMap).forEach(System.out::println);
        // Note there are nC2 subSequences of size 2 i.e n*(n-1)/2
        return count;
    }
}