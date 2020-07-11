package in.samratc.main.dynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String... args) {
        int[] arr = {45, 17, 34, 27, 12, 22};
        System.out.println(new MatrixChainMultiplicationSol().solve(arr));
    }
}

class MatrixChainMultiplicationSol {
    //sizes represents chain of 2-D matrices such that the dimensions of i'th matrix is sizes[i-1] x sizes[i].
    public int solve(int[] sizes) {
        int n = sizes.length;
        //mul[i][j] denotes the min no of multiplications requited to multiply matrix [i-j]
        int[][] mul = new int[n][n];
        //For chain of length 0 and 1 we know the number of multiplication required is 0

        //finding the number of multiplications required for chains of length 2
        //Finding no of multiplications required to multiply i and (i+1)'th Matrix (For all the matrices from 1 to n-1)
        for (int i = 1; i < n - 1; i++)
            mul[i][i + 1] = sizes[i - 1] * sizes[i] * sizes[i + 1];

        //for all chain length [3 to n-1]
        for (int l = 3; l <= n - 1; l++) {
            for (int i = 1; i + l - 1 <= n - 1; i++) {
                int j = i + l - 1;
                mul[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    mul[i][j] = Math.min(mul[i][j], (sizes[i - 1] * sizes[k] * sizes[j]) + mul[i][k] + mul[k + 1][j]);
                }
            }
        }
        //Arrays.stream(mul).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return mul[1][n - 1];
    }
}
