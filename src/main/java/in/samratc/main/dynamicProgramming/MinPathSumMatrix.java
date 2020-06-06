package in.samratc.main.dynamicProgramming;

import java.util.Arrays;

public class MinPathSumMatrix {
}


class MinPathSumMatrixSol {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int[][] pathSum = new int[n + 1][m + 1];
        Arrays.fill(pathSum[0], Integer.MAX_VALUE);
        Arrays.fill(pathSum[1], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1)
                    pathSum[i][j] = grid[i - 1][j - 1];
                else
                    pathSum[i % 2][j] = grid[i - 1][j - 1] + Math.min(pathSum[(i - 1) % 2][j], pathSum[i % 2][j - 1]);
            }
        }
        return pathSum[n % 2][m];
    }

}