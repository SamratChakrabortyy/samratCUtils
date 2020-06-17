package in.samratc.main.dynamicProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountOddPalindromeSubSeq {
    public static void main(String... args) {
        System.out.println(Arrays.toString(new CountOddPalindromeSubSeqSol().solve("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));// 1 2 4
    }
}

class CountOddPalindromeSubSeqSol {
    public int[] solve(String str) {
        int n = str.length();
        long mod = (long) (1e9 + 7);
        long[][] countCommSubSeq = new long[n + 1][n + 1];
        IntStream.range(0, n + 1).forEach(i -> {
            countCommSubSeq[0][i] = 1L;
            countCommSubSeq[i][0] = 1L;
        });
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                    Say
                 */

                countCommSubSeq[i][j] = ((countCommSubSeq[i - 1][j] + countCommSubSeq[i][j - 1]) % mod - countCommSubSeq[i - 1][j - 1] + mod) % mod;
                countCommSubSeq[i][j] += str.charAt(i - 1) == str.charAt(n - 1 - j + 1) ? countCommSubSeq[i - 1][j - 1] : 0L;
                countCommSubSeq[i][j] %= mod;
            }
        }
        //Arrays.stream(countCommSubSeq).forEachOrdered(arr -> System.out.println(Arrays.toString(arr)));
        return IntStream.range(0, n).map(i -> (int) countCommSubSeq[i + 1 - 1][n - i - 1]).toArray();
    }
}
