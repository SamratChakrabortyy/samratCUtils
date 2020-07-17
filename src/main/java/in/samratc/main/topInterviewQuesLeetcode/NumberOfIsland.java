package in.samratc.main.topInterviewQuesLeetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIsland {

    int[] par;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length, m = grid[0].length;
        par = new int[n*m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    par[i*m+j] = i*m+j;
                    if(i>0 && grid[i-1][j] == '1')
                        union(i*m+j, (i-1)*m+j);
                    if(j>0 && grid[i][j-1] == '1')
                        union(i*m+j, i*m+(j-1));
                }
            }
        }
        Set<Integer> islands = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                islands.add(find(i * m + j));
            }
        }
        return islands.size();
    }

    private void union(int a, int b){
        int c = find(a);
        int d = find(b);
        if(c != d)
            par[c] = d;
    }

    private int find(int a){
        if(a == par[a])
            return a;
        par[a] = find(par[a]);
        return par[a];
    }


    //Driver
    public static void main(String... args){
        char[][] arr = {
                {'1','1','1','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}
        };
        System.out.println(new NumberOfIsland().numIslands(arr));
    }

}
