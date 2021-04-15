package dp;


public class Leetcode714 {

    public int maxProfit(int[] prices, int fee) {
        int havingstock, nothavingstock;
        havingstock = -prices[0];
        nothavingstock = 0;

        for (int i = 1; i < prices.length; i++) {
            havingstock = Math.max(havingstock, nothavingstock - prices[i]);
            nothavingstock = Math.max(nothavingstock, havingstock + prices[i] - fee);
        }
        return nothavingstock;
    }
}
