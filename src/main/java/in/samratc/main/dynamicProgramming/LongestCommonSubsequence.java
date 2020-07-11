package in.samratc.main.dynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String... args) {
        System.out.println(new LongestCommonSubsequenceSol().solve("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a"));
    }

}

class LongestCommonSubsequenceSol {

    public int solve(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if (n == 0 || m == 0)
            return 0;
        int[][] subSeqLen = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                subSeqLen[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? 1 + subSeqLen[i - 1][j - 1] : Math.max(subSeqLen[i - 1][j], subSeqLen[i][j - 1]);
            }
        }
        return subSeqLen[n][m];
    }

    String responseString,macAddress,statusCode;

    @Override
    public String toString() {
        String jsonStrResp = responseString.length() > 0 && responseString.charAt(0) == '{' ? responseString.toString(): "\""+ responseString + "\"";
        return String.format("{\n" +
                "\t\"response\" :%s,\n" +
                "\t\"macAddress\" :\"%s\",\n" +
                "\t\"status\" : %d\n" +
                "}",responseString,macAddress,statusCode);
    }

}
