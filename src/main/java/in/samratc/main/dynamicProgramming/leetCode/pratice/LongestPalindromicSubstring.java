package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.stream.IntStream;


// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int n = s.length(), max = 1, start = 0, end = 0;
        boolean[][] isPal = new boolean[n][n];
        IntStream.range(0, n).forEach(i -> isPal[i][i] = true);
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                max = 2;
                start = i;
                end = i + 1;
                isPal[i][i + 1] = true;
            }
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;
                    if (max < l) {
                        max = l;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /*
                            a       a       a       b       b
                        a   1       0       0       0       0
                        a   0       1       0       0       0
                        a   0       0       1       0       0
                        b   0
                        b
     */

    //Driver
    public static void main(String... args){
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaabbaba"));
    }
}
