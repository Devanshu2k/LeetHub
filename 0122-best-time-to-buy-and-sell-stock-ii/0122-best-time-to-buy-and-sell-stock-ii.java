class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return dfs(prices, 0, 0);
    }

    int dfs(int[] prices, int day, int holding) {
        if (day == prices.length) return 0;
        if (dp[day][holding] != null) return dp[day][holding];

        int ans;
        if (holding == 0) {
            ans = Math.max(
                dfs(prices, day + 1, 1) - prices[day], // buy
                dfs(prices, day + 1, 0)                // skip
            );
        } else {
            ans = Math.max(
                dfs(prices, day + 1, 0) + prices[day], // sell
                dfs(prices, day + 1, 1)                // hold
            );
        }

        return dp[day][holding] = ans;
    }
}
