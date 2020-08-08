package in.samratc.main.graphs;

import java.util.Arrays;
import java.util.stream.Collectors;

        public class LongestSteepestPath {
            private static final int[] rows = {0, 0, 1, -1}, cols = {1, -1, 0, 0};

            /**
             * @param grid The matrix which shows the topography of the area
             * @return [length of the path, steepness of the path]
             */
            public int[] longestSteepestPath(int[][] grid) {
                if (grid == null || grid.length == 0)
                    return new int[]{0, 0};
                int n = grid.length, m = grid[0].length;
                int[][][] length = new int[n][m][2];
                Arrays.stream(length).forEach(arr -> Arrays.fill(arr, new int[]{-1, -1}));
                int[] ans = {-1, -1};
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (length[i][j][0] == -1)
                            dfs(i, j, grid, length);
                    }
                }
                //Arrays.stream(length).forEach(arr -> System.out.println(Arrays.stream(arr).map(Arrays::toString).collect(Collectors.toList())));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (ans[0] < length[i][j][0]) {
                            ans[0] = length[i][j][0];
                            ans[1] = grid[i][j] - length[i][j][1];
                        } else if (ans[0] == length[i][j][0] && ans[1] < grid[i][j] - length[i][j][1]) {
                            ans[0] = length[i][j][0];
                            ans[1] = grid[i][j] - length[i][j][1];
                        }
                    }
                }
                return ans;
            }

            private void dfs(int row, int col, int[][] grid, int[][][] length) {
                length[row][col] = new int[]{0, grid[row][col]};
                for (int i = 0; i < 4; i++) {
                    int r = row + rows[i], c = col + cols[i];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] < grid[row][col]) {
                        if (length[r][c][0] == -1)
                            dfs(r, c, grid, length);
                        if (length[row][col][0] < length[r][c][0] + 1) {
                            length[row][col][0] = length[r][c][0] + 1;
                            length[row][col][1] = length[r][c][1];
                        } else if (length[row][col][0] == (length[r][c][0] + 1) && length[row][col][1] > length[r][c][1])
                            length[row][col][1] = length[r][c][1];
                    }
                }
                //return length[row][col];
            }

            //Driver
            public static void main(String... args) {
                int[][] arr = {
                        {4, 8, 7, 3},
                        {2, 5, 9, 3},
                        {6, 3, 2, 5},
                        {4, 4, 1, 6}
                };
                System.out.println(Arrays.toString(new LongestSteepestPath().longestSteepestPath(arr)));
            }
        }
