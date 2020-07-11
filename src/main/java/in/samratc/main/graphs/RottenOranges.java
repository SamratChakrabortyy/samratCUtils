package in.samratc.main.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String... args){
        int[][] arr = {
                {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
                {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
                {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
                {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
                {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
                {2, 2, 0, 2, 2, 1, 1, 1, 2, 2},
        };
        System.out.println(new RottenOrangesSol().solve(arr));
    }
}

class RottenOrangesSol {
    /**
     * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
     * Each cell can have three values:
     * The value 0 representing an empty cell.
     * The value 1 representing a fresh orange
     * The value 2 representing a rotten orange.
     * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1 instead.
     */

    private static final int[] rows = {-1, 0, 1, 0}, cols = {0, -1, 0, 1};

    public int solve(int[][] oranges) {
        //Null Check
        if (oranges == null || oranges.length == 0)
            return -1;
        int n = oranges.length, m = oranges[0].length;
        int totalCount = 0, rottenCount = 0, days = -1;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oranges[i][j] != 0)
                    totalCount++;
                if (oranges[i][j] == 2) {
                    q.add(getPair(i, j));
                    rottenCount++;
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            //rottenCount += size;
            days++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int k = 0; k < 4; k++) {
                    int r = curr[0] + rows[k], c = curr[1] + cols[k];
                    if (r >= 0 && r < n && c >= 0 && c < m && oranges[r][c] == 1) {
                        q.add(getPair(r, c));
                        oranges[r][c] = 2;
                        rottenCount++;
                    }
                }
            }
        }
        Arrays.stream(oranges).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return rottenCount == totalCount ? days : -1;
    }

    private int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}
