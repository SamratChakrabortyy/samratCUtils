package in.samratc.main.dynamicProgramming.leetCode.pratice;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSell {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, diff = 0;
        for(int price: prices){
            min = Math.min(min, price);
            diff = Math.max(diff, price - min);
        }
        return diff;
    }
}
