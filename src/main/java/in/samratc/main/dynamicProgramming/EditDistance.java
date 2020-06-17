package in.samratc.main.dynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public static void main(String... args) {
        System.out.println(new EditDistanceSol().minDistance("aac", "abac"));
    }

}

class EditDistanceSol {

    public int minDistance(String str, String target) {
        int n = str.length(), m = target.length();
        if (n == 0 || m == 0)
            return Math.max(n, m);
        int[][] editDis = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            editDis[i][0] = i;
        for (int i = 0; i <= m; i++)
            editDis[0][i] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1)
                    editDis[i][j] = str.charAt(i - 1) == target.charAt(j - 1) ? 0 : 1;
                else
                    editDis[i][j] = str.charAt(i - 1) == target.charAt(j - 1) ? editDis[i - 1][j - 1] :
                            1 + Math.min(Math.min(editDis[i - 1][j], editDis[i][j - 1]), editDis[i - 1][j - 1]);
            }
        }

        return editDis[n][m];
    }

}
