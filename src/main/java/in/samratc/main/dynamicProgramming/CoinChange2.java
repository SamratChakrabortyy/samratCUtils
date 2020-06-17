package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange2 {
    public static void main(String... args) {
        System.out.println(new CoinChange2Sol().coinchange2(Arrays.asList(1, 2, 3), 4));
    }
}

class CoinChange2Sol {
    public int coinchange2(List<Integer> coins, int n) {
        int m = coins.size();
        long mod = (long) 1e6 + 7;
        long[][] ways = new long[2][n + 1];
        Arrays.fill(ways[0], 0L);
        ways[1][0] = ways[0][0] = 1L;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ways[i % 2][j] = ways[(i - 1) % 2][j];
                if (j >= coins.get(i - 1))
                    ways[i % 2][j] += ways[i % 2][j - coins.get(i - 1)];
                ways[i % 2][j] %= mod;
            }
        }
        return (int) ways[m % 2][n];
    }
}
