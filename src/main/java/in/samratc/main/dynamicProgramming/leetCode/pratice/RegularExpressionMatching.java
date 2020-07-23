package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (isEmpty(s))
            s = "";
        if (isEmpty(p))
            p = "";
        int n = s.length(), m = p.length();

        boolean[][] isMatch = new boolean[n + 1][m + 1];
        isMatch[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*' && i > 1)
                isMatch[0][i] = isMatch[0][i - 2];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.' || (p.charAt(j - 1) == s.charAt(i - 1)))
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (isMatch[i][j - 2] || // Matching 0 instance of preceding character
                            (
                                    (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) &&
                                            (isMatch[i][j - 1] || // Matching exactly 1 instance of character
                                                    isMatch[i - 1][j]) // Matching multiple instance of character
                            )
                    ) {
                        //System.out.println(String.format("%d %d %s",));
                        isMatch[i][j] = true;
                    }
                }
            }
        }
        //Arrays.stream(isMatch).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return isMatch[n][m];
    }

    private static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    //Driver
    public static void main(String... args) {
        System.out.println(new RegularExpressionMatching().isMatch(null, "c*.*a*"));
    }
}
