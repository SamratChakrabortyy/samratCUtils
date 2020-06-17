package in.samratc.main.dynamicProgramming;

public class SubMatrixSumQueries {
}

class SubMatrixSumQueriesSol {
    public int[] solve(int[][] matrix, int[] b, int[] c, int[] d, int[] e) {
        int n = matrix.length, q = b.length;
        long mod = (long) 1e9 + 7;
        int[] ans = {};
        if (n < 0)
            return ans;
        int m = matrix[0].length;

        //matSum[i][j] denotes the sum of teh matrix formed by [0.0] and [i,j]
        long[][] matSum = new long[n + 1][m + 1];
        ans = new int[q];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matSum[i][j] = ((((matSum[i - 1][j] + matSum[i][j - 1]) % mod + matrix[i - 1][j - 1]) % mod) - matSum[i - 1][j - 1] + mod) % mod;
            }
        }
        for (int i = 0; i < q; i++) {
            int r1 = b[i], c1 = c[i], r2 = d[i], c2 = e[i];
            ans[i] = (int) (matSum[r2][c2] - matSum[r1 - 1][c2] - matSum[r2][c1 - 1] + matSum[r1 - 1][c1 - 1]);
        }
        return ans;
    }
}
