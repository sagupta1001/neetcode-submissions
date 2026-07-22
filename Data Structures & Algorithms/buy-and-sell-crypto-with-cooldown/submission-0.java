class Solution {
    // Problem
    // return max profit

    // Approach
    // buy on day 0 and sell on day 1, compute profit
    // buy on day 3 or later.
    // current min = 1
    // buy at current min
    // index 1, if less than current min then 
    // - update buy to be at current index
    // - else sell and track profit
    // index 2, if profit

    private Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) return 0;
        String key = i + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i+1, buying, prices);
        if (buying) {
            int buy = dfs(i+1, false, prices) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i+2, true, prices) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
