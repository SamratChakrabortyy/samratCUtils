package in.samratc.main.graphs;

import in.samratc.util.Pair;

import java.util.Stack;

public class CountIslands {
}

class CountIslandsSol {
    private static final int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] cols = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int solve(int[][] grid) {
        //Null Check
        if(grid == null)
            return 0;
        int n = grid.length;
        //size check
        if(n == 0)
            return  0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        //stack for DFS
        Stack<Pair<Integer, Integer>> stk  = new Stack<>();
        // This will store the count of the islands
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                    stk.push(new Pair<>(i, j));
                    while (!stk.empty()){
                        Pair<Integer, Integer> curr = stk.pop();
                        visited[curr.val1][curr.val2] = true;
                        for(int k = 0; k < 8 ; k++){
                            int r = curr.val1 + rows[k], c = curr.val2 + cols[k];
                            if(r >= 0 && r  < n && c >= 0 && c < m && grid[r][c] == 1 && !visited[r][c]){
                                stk.push(new Pair<>(r, c));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
