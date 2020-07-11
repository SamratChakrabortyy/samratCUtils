package in.samratc.main.dynamicProgramming;

import java.util.Arrays;

public class DistinctCommonSubSeqCount {

    public static void main(String... ar) {
        System.out.println(new DistinctCommonSubSeqCountSol().numDistinct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}

class DistinctCommonSubSeqCountSol {

    public int numDistinct(String str, String target) {
        int n = str.length(), m = target.length();
        if (n == 0)
            return 0;
        if (m == 0)
            return 1;
        int[][] subSeqCount = new int[n + 1][m + 1];
        subSeqCount[0][0] = 1;
        for (int i = 1; i <= n; i++)
            subSeqCount[i][0] = 1;
        for (int i = 1; i <= m; i++)
            subSeqCount[0][i] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                subSeqCount[i][j] = subSeqCount[i - 1][j];
                subSeqCount[i][j] += str.charAt(i - 1) == target.charAt(j - 1) ? subSeqCount[i - 1][j - 1] : 0;
            }
        }
        //Arrays.stream(subSeqCount).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return subSeqCount[n][m];
    }

}
