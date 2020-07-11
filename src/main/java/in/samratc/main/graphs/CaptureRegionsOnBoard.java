package in.samratc.main.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CaptureRegionsOnBoard {
}

class CaptureRegionsOnBoardSol {

    private final int[] rows = {-1 , 1, 0, 0}, cols = {0, 0, -1, 1};
    /**
     * Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * @param board the board containing 'X and 'O'
     */
    public void solve(ArrayList<ArrayList<Character>> board) {
        /*
        *       Approach
        *       ========
        *
        *   We well try to find the connected component where the values in the board = 'O' and it's connected to 4 sides
        */

        //Null check
        if(board == null || board.size() == 0 || board.get(0).size() == 0)
            return;
        int n = board.size(), m = board.get(0).size();
        boolean[][] visited = new boolean[n][m];
        Stack<int[]> stk = new Stack<>();
        for(int i =  0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board.get(i).get(j) == 'O' && !visited[i][j]){
                    stk.push(getPair(i, j));
                    visited[i][j] = true;
                    boolean isVertex = false;
                    List<int[]> component = new ArrayList<>();
                    while(!stk.empty()){
                        int[] curr = stk.pop();
                        if(curr[0] == 0 || curr[0] == n-1 || curr[1] == 0 || curr[1] == m-1)
                            isVertex = true;
                        component.add(curr);
                        for(int k = 0; k < 4; k++){
                            int r = curr[0] + rows[k], c = curr[1] + cols[k];
                            if(r >= 0 && r < n && c >=0 && c < m && !visited[r][c] && board.get(r).get(c) == 'O'){
                                stk.push(getPair(r, c));
                                visited[r][c] = true;
                            }
                        }
                    }
                    if(!isVertex){
                        for(int[] point : component)
                            board.get(point[0]).set(point[1], 'X');
                    }
                }
            }
        }
    }

    private int[] getPair(int x, int y){
        return new int[] {x, y};
    }
}
