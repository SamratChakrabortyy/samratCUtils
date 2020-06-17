package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestFibLikeSeq {
}


class LongestFibLikeSeqSol {
    public int solve(ArrayList<Integer> list) {
        if(null == list || list.size() < 3)
            return 0;
        int n = list.size(), x = list.get(0), y = list.get(1), maxLen = 0;
        Set<Integer> nums = new HashSet<Integer>(list);
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j <n; j++){
                int len = 3;
                x = list.get(i);
                y = list.get(j);
                int z = x + y;
                while(nums.contains(z) && z < list.get(n-1)){
                    x = y;
                    y = z;
                    z = x + y;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }
        return maxLen;
    }
}
