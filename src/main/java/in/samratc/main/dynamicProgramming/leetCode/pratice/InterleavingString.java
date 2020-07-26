package in.samratc.main.dynamicProgramming.leetCode.pratice;

// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (isEmptyStr(s1)) s1 = "";
        if (isEmptyStr(s2)) s2 = "";
        if (isEmptyStr(s3)) s3 = "";
        if (s3.equals(s1 + s2) || s3.equals(s2 + s1))
            return true;
        if(s1.length() + s2.length() != s3.length())
            return false;
        int n = s1.length(), m = s2.length();
        /*
        "matched" represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position. 0th position means empty string.
        So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. If only s1 is empty, then if previous s2 position is
        interleaving and current s2 position char is equal to s3 current position char, it is considered interleaving. similar idea applies to when s2 is empty.
        when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal,
        it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal. it is interleaving.
        */

        boolean[][] matched = new boolean[n + 1][m + 1];

        matched[0][0] = true;
        for (int i = 1; matched[i - 1][0] && i <= n; i++)
            matched[i][0] = matched[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        for (int i = 1; matched[0][i - 1] && i <= m; i++)
            matched[0][i] = matched[0][i - 1] && s3.charAt(i - 1) == s2.charAt(i - 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matched[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && matched[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && matched[i][j - 1]);
            }
        }
        return matched[n][m];
    }

    private boolean isEmptyStr(String s) {
        return s == null || s.length() == 0;
    }
}
