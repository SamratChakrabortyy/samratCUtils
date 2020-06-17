package in.samratc.main.dynamicProgramming;

public class RegexMatch {

    public static void main(String... args) {
        System.out.println(new RegexMatchSol().isMatch("cc", "***??"));
    }

}

class RegexMatchSol {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String str, final String pattern) {
        int n = str.length(), m = pattern.length();

        boolean[][] isMatch = new boolean[n + 1][m + 1];
        isMatch[0][0] = true;
        for (int i = 1; i <= n; i++)
            isMatch[i][0] = false;
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*')
                isMatch[0][i] = isMatch[0][i - 1];
            else
                isMatch[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    isMatch[i][j] = isMatch[i - 1][j] || isMatch[i][j - 1];
                } else {
                    isMatch[i][j] = false;
                }
            }
        }
        return isMatch[n][m] ? 1 : 0;
    }

}

