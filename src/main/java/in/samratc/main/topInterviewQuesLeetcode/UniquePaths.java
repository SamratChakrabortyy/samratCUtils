package in.samratc.main.topInterviewQuesLeetcode;

public class UniquePaths {
    /**
     *  A robot is located at the top-left corner of a m x n grid
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid
     * How many possible unique paths are there?
     */
    public int uniquePaths(int m, int n) {
        int[][] pathCount = new int[2][m+1];
        pathCount[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j == 1)
                    continue;
                pathCount[i%2][j] = pathCount[(i-1)%2][j] + pathCount[i%2][j-1];
            }
        }
        return pathCount[n%2][m];
    }
}
