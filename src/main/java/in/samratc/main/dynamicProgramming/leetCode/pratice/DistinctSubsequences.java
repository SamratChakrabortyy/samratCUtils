package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.stream.IntStream;

// https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(isEmpty(t)) // Empty target is a Subsequence of any String
            return 1;
        if(isEmpty(s)) // No non empty Subsequence can be formed by empty source
            return 0;
        /*
            count[i][j] = the number of subSeq of s[0, i] == t[0, j]

            count[i][j]
                if s[i] == t[j] => count[i-1][j-1] + count[i-1][j]
                else count[i-1][j]
         */
        int n = s.length(), m = t.length();
        int[][] count = new int[n+1][m+1];

        // Base case empty target string is the subSeq of any String
        IntStream.range(0, n).forEach(i->count[i][0] = 1);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                count[i][j] = count[i-1][j] + (s.charAt(i-1) == t.charAt(j-1) ? count[i-1][j-1] : 0);
            }
        }
        return count[n][m];
    }

    public static boolean isEmpty(String s){
        return  s == null || s.length() == 0;
    }
}
