package in.samratc.main.dynamicProgramming;

public class UniquePathsGrid {
}

class UniquePathsGridSol {

    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int[][] paths = new int[2][m + 1];
        if (grid[0][0] == 1)
            return 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1)
                    paths[i][j] = grid[i - 1][j - 1] == 0 ? 1 : 0;
                else
                    paths[i % 2][j] = grid[i - 1][j - 1] == 0 ? paths[(i - 1) % 2][j] + paths[i % 2][j - 1] : 0;
            }
        }
        return paths[n % 2][m];
    }
}
