package in.samratc.main.dynamicProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountOddPalindrome {
    public static void main(String... args) {
        System.out.println(Arrays.toString(new CountOddPalindromeSol().solve("ababzz")));
    }
}

class CountOddPalindromeSol {
    public int[] solve(String str) {
        int n = str.length(), mod = (int) 1e7;
        int[] count = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        IntStream.range(0, n).forEachOrdered(i -> {
            isPalindrome[i][i] = true;
            count[i] = 1;
        });
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    isPalindrome[i][j] = isPalindrome[i - 1][j + 1];
                    if (isPalindrome[i][j]) {
                        int mid = j + (i - j) / 2;
                        count[mid]++;
                        count[mid] %= mod;
                    }
                }
            }
        }
        //Arrays.stream(isPalindrome).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return count;
    }
}
