package in.samratc.main.dynamicProgramming;

public class RetangleSum {
    public static void main(String... args) {
        int[][] arr = {
                {1, 3, -2},
                {1, 4, 6},
                {-4, -2, 1}
        };
        System.out.println(new RetangleSumSol().solve(arr));
    }
}

class RetangleSumSol {
    public int solve(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int globalMax = 0;
        /*
            Approach
            Merging multiple rows in one array of size of columns and implementing Kadane's Algorithm.
        */
        for (int i = 0; i < n; i++) {
            int[] arr = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++)
                    arr[k] += grid[j][k];
                int curr = 0;
                for (int k = 0; k < m; k++) {
                    curr += arr[k];
                    globalMax = Math.max(globalMax, curr);
                    curr = Math.max(0, curr);
                }
            }
        }
        return globalMax;
    }
}
