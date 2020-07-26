package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class BuyAndSell3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length, max = Integer.MIN_VALUE;
        int[] nextMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            int prev = i == n-1 ? -1 : nextMax[i+1];
            nextMax[i] =Math.max(prev , max - prices[i]);
        }
        int min = Integer.MAX_VALUE, diff = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            int next = i == n - 1 ? 0 : nextMax[i + 1];
            diff = Math.max(diff, prices[i] - min + next);
        }
        return diff;
    }

    //Driver
    public static void main(String... args){
        BuyAndSell3 bs3 = new BuyAndSell3();
        System.out.println(bs3.maxProfit(new int[] {6,1,3,2,4,7}));
        System.out.println(bs3.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(bs3.maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(bs3.maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(bs3.maxProfit(new int[] {3,2,6,5,0,3}));
    }
}
