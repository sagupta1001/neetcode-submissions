// problem
// prices where ith index is the price of 
// neetcoin on the ith day
// buy on a single day and sell on a different
// day
// return maximum profit
// no transactions means profit is zero

// examples
// [10,1,5,6,7,1]

// approach
// initial max profit is zero i.e. no transactions
// buy on day 1, 
// if day 2 price is higher then update max profit
// if day 2 price is lower or same then reset buy to be day 2 

// [1, 100, 2, 105]
// buyDay remains at 0
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int buyDay = 0;
        
        for (int curDay = 1; curDay < prices.length; curDay++) {
            maxProfit = Math.max(maxProfit, prices[curDay] - prices[buyDay]);
            if (prices[curDay] < prices[buyDay]) buyDay = curDay;
        }

        return maxProfit;
    }
}
