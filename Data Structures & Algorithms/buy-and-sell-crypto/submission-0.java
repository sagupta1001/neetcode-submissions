class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - curBuy;
            if (curProfit <= 0) {
                curBuy = prices[i];
            } else {
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }

        }

        return maxProfit;
    }
}
