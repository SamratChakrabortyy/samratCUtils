package in.samratc.main.dynamicProgramming;

public class RegExp2 {

    public static void main(String... args) {
        System.out.println(new RegexMatchSol().isMatch("baaaaaabaaaabaaaaababababbaab", "..a*aa*a.aba*a*bab*"));
    }

}

class RegExp2Sol {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String str, final String pattern) {
        int n = str.length(), m = pattern.length();
        boolean[][] isMatch = new boolean[n + 1][m + 1];
        isMatch[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                else if (pattern.charAt(j - 1) == '*') {
                    if (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')
                        isMatch[i][j] = isMatch[i][j - 2] || isMatch[i][j - 1] || isMatch[i - 1][j];
                    else
                        isMatch[i][j] = isMatch[i][j - 2];
                }
            }
        }
        return isMatch[n][m] ? 1 : 0;
    }

}
