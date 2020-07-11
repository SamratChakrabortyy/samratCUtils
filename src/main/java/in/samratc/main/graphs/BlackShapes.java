package in.samratc.main.graphs;

import java.awt.*;
import java.util.*;

public class BlackShapes {
}

class BlackShapesSol {
    private int[] rows = {1, -1, 0, 0}, cols = {0, 0, 1, -1};
    public int black(String[] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length, m = grid[0].length(), count = 0;
        boolean[][] visited = new boolean[n][m];
        Stack<Point> stk = new Stack<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j <m ; j++){
                if(grid[i].charAt(j) == 'X' && !visited[i][j]){
                    count++;
                    stk.push(new Point(i, j));
                    while(!stk.empty()){
                        Point curr = stk.pop();
                        visited[(int)curr.getX()][(int)curr.getY()] = true;
                        for(int k = 0; k < 4; k++){
                            int x = (int)curr.getX() + rows[k], y = (int)curr.getY() + cols[k];
                            if(x >= 0 && x < n && y >= 0 && y < m && grid[x].charAt(y) == 'X')
                                stk.push(new Point(x, y));
                        }
                    }
                }
            }
        }
        return count;
    }
}