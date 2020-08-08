package in.samratc.main.arrays;

import java.util.Arrays;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n < 0)
            throw new IllegalStateException("Size of Matrix Cannot be negative");
        if (n == 0)
            return new int[][]{{}};
        int[][] matrix = new int[n][n];
        int r = n / 2, c = n / 2, count = 1, l = 1;
        matrix[r][c] = count++;
        while (count <= n * n) {
            for (int i = 0; c < n-1 && i < l; i++) {
                c++;
                matrix[r][c] = count++;
            }
            for (int i = 0; r < n-1 && i < l; i++) {
                r++;
                matrix[r][c] = count++;
            }
            l++;
            for (int i = 0; c > 0 && i < l; i++) {
                c--;
                matrix[r][c] = count++;
            }
            for (int i = 0; r > 0 && i < l; i++) {
                r--;
                matrix[r][c] = count++;
            }
        }
        return matrix;
    }

    public static void main(String... args){
        SpiralMatrix2 sm = new SpiralMatrix2();
        Arrays.stream(sm.generateMatrix(8)).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
