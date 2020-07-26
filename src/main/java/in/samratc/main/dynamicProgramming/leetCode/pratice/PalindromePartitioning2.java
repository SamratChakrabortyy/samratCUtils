package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.stream.IntStream;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();

        // pal[i][j] denotes if the s[i, j] is a palindrome or not
        boolean[][] pal = new boolean[n][n];
        // Base case Palindromes of length 1 and 2
        IntStream.range(0, n).forEach(i -> pal[i][i] = true);
        IntStream.range(0, n - 1).forEach(i -> pal[i][i + 1] = s.charAt(i) == s.charAt(i + 1));

        //Palindromes for length > 2
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i + l - 1 <= n - 1; i++) {
                int j = i + l - 1;
                pal[i][j] = s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1];
            }
        }
        // minCuts[i] represent the min cuts to partition Palindromes of s[0, i];
        int[] minCuts = new int[n];
        minCuts[0] = 0;
        for (int i = 1; i < n; i++) {
            minCuts[i] = i;
            for (int j = 0; j <= i; j++) {
                if (pal[j][i]) {
                    int last = j > 0 ? minCuts[j-1] : -1;
                    minCuts[i] = Math.min(minCuts[i], last + 1);
                }
            }
        }
        return minCuts[n - 1];
    }

    //Driver
    public static void main(String... args){
        PalindromePartitioning2 pp2 = new PalindromePartitioning2();
        System.out.println(pp2.minCut("aab"));
        System.out.println(pp2.minCut(""));
        System.out.println(pp2.minCut(null));
        System.out.println(pp2.minCut("aa"));
        System.out.println(pp2.minCut("aev"));
    }
}
