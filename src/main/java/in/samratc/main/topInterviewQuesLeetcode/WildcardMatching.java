package in.samratc.main.topInterviewQuesLeetcode;


import java.util.Arrays;

// https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
     * <p>
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     */

    public static void main(String... args){
        System.out.println(new WildcardMatching().isMatch("bbbaab","a**?***"));
    }
    public boolean isMatch(String s, String p) {
        if(p == null)
            return false;
        int countStar = 0;
        for(int i = 0 ; i < p.length() && p.charAt(i) == '*'; i++)
            countStar++;
        if (s == null && p.length() == countStar)
            return true;
        if (s == null)
            return false;

        int n = s.length(), m = p.length();
        /*
         *   let isMatch[i][j] = true if s[0,i] is matched by p[0,j]
         *   isMatch[i][j] =
         *          s[i] == p[j] or p[j] == '?' -> isMatch[i-1][j-1]
         *          p[j] == '*'
         *               isMatch[i][j-1] // * matches empty sequence
         *               or isMatch[i-1][j-1] // * matches a single char
         *               or isMatch[i-1][j] // * matches any number of character
         *
         */

        boolean[][] isMatch = new boolean[n+1][m + 1];
        //Base case (null pattern matches with null string
        isMatch[0][0] = true;
        //Any number of consecutive '*' can match with null string
        for (int i = 1; i <= m && p.charAt(i - 1) == '*'; i++)
            isMatch[0][i] = true;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    isMatch[i][j] = isMatch[(i - 1)][j - 1];
                else if (p.charAt(j - 1) == '*')
                    isMatch[i][j] = isMatch[i][j - 1] || isMatch[(i - 1)][j - 1] || isMatch[(i - 1)][j];
                else
                        isMatch[i][j] = false;
            }
        }
        //Arrays.stream(isMatch).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return isMatch[n][m];
    }
}
