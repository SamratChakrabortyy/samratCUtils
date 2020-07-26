package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class MinPathSunTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = 1; i < n ; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int min = j > 0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                if(j < triangle.get(i-1).size())
                    min = Math.min(min, triangle.get(i-1).get(j));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(n-1).stream().min(Integer::compareTo).get();
    }
}
