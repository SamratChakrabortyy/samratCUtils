package in.samratc.main.topInterviewQuesLeetcode;


//https://leetcode.com/problems/regular-expression-matching/
public class RegExMatch {
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * <p>
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     */
    public boolean isMatch(String str, String pat) {
        if (str == null && pat == null)
            return false;
        /*
         *      isMatch[i][j]  = true if str[1,i] is matched by pat[1,j]
         *
         *      cases:
         *          pat[j] == '.' || pat[j] == str[i] -> isMatch[i-1][j-1]
         *          pat[j] == '*'
         *              pat[j-1] != str[i] -> isMatch[i][j-2] // no occurrence of a*
         *              pat[j-1] == str[i]
         *                      isMatch[i-1][j] // any no of occurrence of a
         *                      or isMatch[i][j-1] // single occurrence
         *                      or isMatch[i][j-2] // no occurrence of a*
         */
        int n = str.length(), m = pat.length();
        boolean[][] isMatch = new boolean[n + 1][m + 1];

        //Base cases
        isMatch[0][0] = true;
        //Match empty string using a*
        for (int j = 2; j <= m; j++) {
            if (pat.charAt(j - 1) == '*' && isMatch[0][j - 2])
                isMatch[0][j] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pat.charAt(j - 1) == str.charAt(i - 1) || pat.charAt(j - 1) == '.')
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                else if (pat.charAt(j - 1) == '*') {
                    if (pat.charAt(j - 2) == str.charAt(i - 1) || pat.charAt(j - 2) == '.')
                        isMatch[i][j] = isMatch[i - 1][j] || isMatch[i][j - 1] || isMatch[i][j - 2];
                    else
                        isMatch[i][j] = isMatch[i][j - 2];
                }
            }
        }
        return isMatch[n][m];
    }
}

