package in.samratc.main.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinDistance {
}

class MinDistanceSol {

    private static final int[] rows = {-1, 0, 1, 0}, cols = {0, -1, 0, 1};

    public int[][] solve(int[][] matrix) {
        //Null Check
        if (matrix == null || matrix.length == 0)
            return matrix;
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    q.add(getPair(i, j));
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                ans[curr[0]][curr[1]] = step;
                for (int k = 0; k < 4; k++) {
                    int r = curr[0] + rows[k], c = curr[1] + cols[k];
                    if (r >= 0 && r < n && c >= 0 && c < m && matrix[r][c] == 0) {
                        q.add(getPair(r, c));
                        matrix[r][c] = 1;
                    }
                }
            }
            step++;
        }
        //Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return ans;
    }

    private int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}
