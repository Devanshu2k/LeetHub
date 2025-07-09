class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // holding a stock on day 0
        int cash = 0;          // not holding any stock on day 0

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        return cash; // at the end, max profit will be in 'cash'
    }
}