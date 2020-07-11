package in.samratc.main.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessBoard {
}

class KnightChessBoardSol {
    /**
     * Knight On Chess Board
     * Problem Description
     * <p>
     * Given any source point, (C, D) and destination point,
     * (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
     * <p>
     * If yes, then what would be the minimum number of steps for the knight to move to the said point.
     * If knight can not move from the source point to the destination point, then return -1.
     */

    private final int[] rows = {1, 1, -1, -1, 2, 2, -2, -2};
    private final int[] cols = {2, -2, 2, -2, 1, -1, 1, -1};

    public int knight(int n, int m, int srcX, int srcY, int destX, int destY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(getPair(srcX, srcY));
        visited[srcX][srcY] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                if (visited[destX][destY])
                    return steps;
                for (int k = 0; k < 8; k++) {
                    int r = curr[0] + rows[k], c = curr[1] + cols[k];
                    if (r >= 0 && r < n && c >= 0 && c < m && !visited[r][c]) {
                        q.add(getPair(r, c));
                        visited[r][c] = true;
                    }
                }
            }
        }
        return -1;
    }

    private int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}
