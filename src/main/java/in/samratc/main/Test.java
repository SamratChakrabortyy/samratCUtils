package in.samratc.main;

import java.util.Arrays;
import java.util.Scanner;

public class Test {



    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b)
                        continue;
                    if (Math.abs(arr[k] - arr[i]) > c)
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    public int getWinner(int[] arr, int k) {
        int max = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (i - k + 1 > 0 && arr[i - k + 1] == max)
                return max;
            if (i - k >= 0 && arr[i - k] == max)
                return max;
            //System.out.println(i + " " +max + ( i- k + 1));
        }
        return max;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    count++;
                else
                    break;
            }
            arr[i] = count;
        }
        int swaps = 0;
        for(int i = 0; i < n ; i++){
            while(arr[i] < n- i - 1){

            }
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] < n-i-1)
                return -1;
        }
        return swaps;
    }





    public static void main(String... args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println((1 << 3));
            //Integer.bin
        } catch (Exception ex){
            System.out.println("RunTime Error");
            ex.printStackTrace();
            throw ex;
        }
    }
}