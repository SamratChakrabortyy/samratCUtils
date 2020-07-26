package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.Arrays;

public class BuyAndSellK {
    private final int k;

    BuyAndSellK(int _k) {
        k = _k;
    }

    public int maxProfit(int[] prices) {
        //int n = prices.length;
        int[] maxProf = new int[k + 1], min = new int[k + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(maxProf, 0);
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                min[j] = Math.min(min[j], price - maxProf[j - 1]);
                maxProf[j] = Math.max(maxProf[j], price - min[j]);
            }
        }
        return maxProf[k];
    }

    //Driver
    public static void main(String... args) {
        BuyAndSellK bs3 = new BuyAndSellK(1);
        System.out.println(bs3.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println(bs3.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(bs3.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(bs3.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(bs3.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println("\n\n");
        bs3 = new BuyAndSellK(2);
        System.out.println(bs3.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println(bs3.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(bs3.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(bs3.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(bs3.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}