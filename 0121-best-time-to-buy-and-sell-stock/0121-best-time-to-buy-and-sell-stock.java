class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;

        for(int r=1;r<prices.length;r++){
            if(prices[r]<prices[l])
                l = r;
            maxProfit = Math.max(maxProfit,prices[r]-prices[l]);
        }
        return maxProfit;

    }
}