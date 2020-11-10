package dp;

public class Leetcode309 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/240097/Come-on-in-you-will-not-regret-most-general-java-code-like-all-other-DP-solutions
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0] = 0;
            } else if (i == 1) {
                dp[1] = Math.max(prices[1] - prices[0], 0);
            } else {
                // cool-down
                dp[i] = dp[i - 1];

                // sell day (linear scan)
                for (int j = 0; j < i; j++) {
                    int prev = j >= 2 ? dp[j - 2] :0;

                    // buy day는 sell day 이전에 언제든지 가능 (scan 하면서 최대 값 갱신)
                    dp[i] = Math.max(dp[i], prev + prices[i] - prices[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
