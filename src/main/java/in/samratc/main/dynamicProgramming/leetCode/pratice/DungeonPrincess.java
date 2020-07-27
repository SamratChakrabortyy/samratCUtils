package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.Arrays;

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        // minHealth[i][j] represent the min health required to reach the bottom right corner from dungeon[i][j]
        int[][] minHealth = new int[n][m];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    minHealth[i][j] = Math.max(1, 1 - dungeon[i][j]);
                    continue;
                }
                int maxR = j < m-1 ? minHealth[i][j+1] : Integer.MAX_VALUE, maxB = i < n-1 ? minHealth[i+1][j] : Integer.MAX_VALUE;
                minHealth[i][j] = Math.max(1, Math.min(maxR, maxB) - dungeon[i][j]) ;
                //minHealth[i][j] = Math.max(dungeon[i][j], 0);
            }
        }
        /*Arrays.stream(dungeon).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("\n");
        Arrays.stream(minHealth).forEach(arr -> System.out.println(Arrays.toString(arr)));*/
        return minHealth[0][0];
    }

    //driver
    public static void main(String... args){
        DungeonPrincess dp = new DungeonPrincess();
        System.out.println(dp.calculateMinimumHP(new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
