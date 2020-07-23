package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1)
            return 0;
        grid[0][0] = 1;
        for(int i = 1; i < n; i++) {
            grid[i][0] = grid[i][0] == 0 ? grid[i-1][0] : 0;
        }
        for(int i = 1; i < m; i++) {
            grid[0][i] = grid[0][i] == 0 ? grid[0][i-1] : 0;
        }
        for(int i = 1; i < n ; i++){
            for(int j = 1; j < m; j++){
                grid[i][j] = grid[i][j] == 1 ? 0 : grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[n-1][m-1];
    }
}
