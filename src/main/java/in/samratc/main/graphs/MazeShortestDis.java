package in.samratc.main.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MazeShortestDis {
}

class MazeShortestDisSol {
    private static final int[] rows = {-1, 0, 1, 0}, cols = {0, -1, 0, 1};

    public int solve(int[][] matrix, int[] src, int[] dest) {
        //Null Check
        if (matrix == null || matrix.length == 0)
            return -1;
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];
        if (matrix[src[0]][src[1]] == 1 || matrix[dest[0]][dest[1]] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        //boolean[][] visited = new boolean[n][m];
        q.add(src);
        matrix[src[0]][src[1]] = 1;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int k = 0; k < 4; k++) {
                    int r = curr[0] + rows[k], c = curr[1] + cols[k];
                    if (r >= 0 && r < n && c >= 0 && c < m && matrix[r][c] == 0) {
                        q.add(getPair(r, c));
                        matrix[r][c] = 1;
                        if (matrix[dest[0]][dest[1]] == 1)
                            return step;
                    }
                }
            }
        }
        //Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return -1;
    }

    private int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}
