package in.samratc.main.graphs;

import java.util.*;

public class ValidPath {
    public static void main(String... args) {

        Date start = new Date();
       /* System.out.println(new ValidPathSol().solve(7, 91, 8, 7,
                new ArrayList<Integer>(Arrays.asList(1, 7, 1, 7, 1, 5, 1, 6)),
                new ArrayList<Integer>(Arrays.asList(25, 4, 74, 14, 90, 58, 37, 4))));
        System.out.println((new Date().getTime() - start.getTime()) / 1000 + "\n");

        start = new Date();
        System.out.println(new ValidPathSol().solve(1, 1, 1, 1,
                new ArrayList<Integer>(Arrays.asList(0)),
                new ArrayList<Integer>(Arrays.asList(0))));
        System.out.println((new Date().getTime() - start.getTime()) / 1000+ "\n");
*/
        start = new Date();
        System.out.println(new ValidPathSol().solve(41,67,5,0,
                new ArrayList<Integer>(Arrays.asList(17, 16, 12, 0, 40)),
                new ArrayList<Integer>(Arrays.asList(52, 61, 61, 25, 31))));
        System.out.println((new Date().getTime() - start.getTime()) / 1000+ "\n");
    }
}

class ValidPathSol {
    /**
     * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
     * There are N circles such that their centers are inside the rectangle.
     * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without
     * touching any circle.
     * Note : We can move from any cell to any of its 8 adjacent neighbours and we cannot move outside the boundary of
     * the rectangle at any point of time.
     *
     * @param x x Coordinate of the end of the rectangle
     * @param y y  Coordinate of the end of the rectangle
     * @param n number of circles
     * @param r radius of circle
     * @param cx x Coordinate of the end of the center of the circles
     * @param cy y Coordinate of the end of the center of the circles
     * @return "YES" if possible "NO" if not
     */

    private int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] cols = {-1, 0, 1, -1, 1, -1, 0, -1};

    public String solve(int x, int y, int n, int r, ArrayList<Integer> cx, ArrayList<Integer> cy) {
        /**
         *          Approach
         *          ========
         *
         *          Start a BFS from (0,0) checking if (x,y) can be reached at every point check the Eucleidian of all the
         *          centres < R
         */
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[x + 1][y + 1], marked = new boolean[x + 1][y + 1];
        //Preprocessing the whole grid, to mark points which cannot be traversed.
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (!marked[i][j]) {
                    for (int k = 0; k < n; k++) {
                        long dist = ((i - cx.get(k)) * (i - cx.get(k))) + ((j - cy.get(k)) * (j - cy.get(k)));
                        if (dist <= (long) r * r)
                            marked[i][j] = true;
                    }
                }
            }
        }
        boolean isReached = false;
        if(!marked[0][0]) {
            q.add(getPair(0, 0));
            visited[0][0] = true;
        }
        while (!isReached && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int k = 0; k < 8; k++) {
                    int x1 = curr[0] + rows[k], y1 = curr[1] + cols[k];
                    if (x1 >= 0 && x1 <= x && y1 >= 0 && y1 <= y && !visited[x1][y1] && !marked[x1][y1]){
                        q.add(getPair(x1, y1));
                        visited[x1][y1] = true;
                        if(visited[x][y])
                            return "YES";
                    }
                }
            }
        }
        return "NO";
    }


    private int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}
