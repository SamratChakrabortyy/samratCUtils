package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class InterleavingStrings {
    public static void main(String... args) {
        System.out.println(new InterleavingStringsSol().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}


class InterleavingStringsSol {
    public int isInterleave(String a, String b, String c) {
        int x = c.length(), y = b.length(), z = a.length();
        if (x != y + z)
            return 0;
        boolean[][][] isPoss = new boolean[x + 1][y + 1][z + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= z; j++)
                isPoss[0][i][j] = true;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if (j == 0 && k == 0)
                        isPoss[i][j][k] = false;
                    else {
                        if (j > 0 && k > 0)
                            isPoss[i][j][k] = isPoss[i][j - 1][k - 1];
                        if (j > 0 && c.charAt(i - 1) == b.charAt(j - 1))
                            isPoss[i][j][k] = isPoss[i][j][k] || isPoss[i - 1][j - 1][k];
                        if (k > 0 && c.charAt(i - 1) == a.charAt(k - 1))
                            isPoss[i][j][k] = isPoss[i][j][k] || isPoss[i - 1][j][k - 1];
                    }
                }
            }
        }
        return isPoss[x][y][z] ? 1 : 0;
    }
}
