package in.samratc.main.dynamicProgramming;

import in.samratc.main.Stack.LargestRectangleHistogram;

public class LargestBinRectangle {
}

class LargestBinRectangleSol{
    public int maximalRectangle(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length, m = grid[0].length, max = 0;
        int arr[] = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1)
                    arr[j]++;
                else
                    arr[j] = 0;
            }
            max = Math.max(max, new LargestRectangleHistogram().largestRectangleArea(arr));
        }
        return max;
    }
}
