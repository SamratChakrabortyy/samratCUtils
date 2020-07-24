package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.stream.IntStream;

// https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null || word2 == null)
            return -1;
        if (word1.equals(word2))
            return 0;
        int n = word1.length(), m = word2.length();
        int[][] dist = new int[n+1][m + 1];
        IntStream.range(0, m + 1).forEach(i -> dist[0][i] = i);
        IntStream.range(0, n + 1).forEach(i -> dist[i][0] = i);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dist[i][j] = dist[i - 1][j - 1];
                else
                    dist[i][j] = Math.min(dist[i - 1][j], Math.min(dist[i][j - 1], dist[i - 1][j - 1])) + 1;
            }
        }
        return dist[n][m];
    }
}
