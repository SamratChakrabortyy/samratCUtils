package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if ((s1 == null || s2 == null) || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int n = s1.length();
        boolean[][][] matched = new boolean[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matched[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l - 1 <= n - 1; i++) {
                for (int j = 0; j + l - 1 <= n - 1; j++) {
                    for (int k = 1; !matched[i][j][l - 1] && k <= l; k++) {
                        matched[i][j][l - 1] = (matched[i][j][k - 1] && matched[i + k][j + k][l - k - 1]) || (matched[i][j + l - k][k - 1] && matched[i + k][j][l - k - 1]);
                    }
                }
            }
        }
        return matched[0][0][n - 1];
    }

    //Driver
    public static void main(String... args) {
        ScrambleString ss = new ScrambleString();
        System.out.println(String.format("%s, %s, %s ", "great", "rgtae", ss.isScramble("great", "rgtae")));
        System.out.println(String.format("%s, %s, %s ", "great", "grtae", ss.isScramble("great", "grtae")));
        System.out.println(String.format("%s, %s, %s ", "great", "egrat", ss.isScramble("great", "egrat")));
        System.out.println(String.format("%s, %s, %s ", "greatness", "sagnreets", ss.isScramble("greatness", "sagnreets")));
    }
}

