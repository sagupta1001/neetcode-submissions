class Solution {
    // Problem
    // Distinct combinations that total up to amount

    // Approach
    // DP / Backtracking

    // [1,2,3], amount = 4
    // at each step we can either pick the denomination or not pick
    // and we check if the total is equal to amount
    // pick 1, check if eq amount
    // pick 1, ..
    // increment numberOfWays = 1

    // pick 1, or leave 1
    // 

    // iterate through denominations
    // pick denomination and keep the same index to pick the same
    // denomination again
    // leave denomination and move index
    // these are two options in this approach

    // making sense so far?

    // Pseudo code
    // change
    // - if amount is zero then return 1
    // - if amount is less than the min of the coin denominations 
    //   then return 0
    // makeChange(amount, coins, 0)

    // makeChange(amount, coins, curIndex)
    // DP coming later
    // - if (amount == 0)
    // -  return 1
    // - if curIndex == coins.length - 1
    // -  return 0
    // return makeChange(amount - coins[curIndex], coins, curIndex) +
    //   makeChange(amount, coins, curIndex + 1)

    // 3 -> 2
    // - 1 -> 
    // 3 -> 1
    // - 2 -> 1

    private int[][] memo;

    private int makeChange(int amount, int[] coins, int curIndex) {
        if (amount == 0) return 1;
        if (curIndex == coins.length) return 0;
        if (amount < 0) return 0;

        if (memo[amount][curIndex] != -1) {
            return memo[amount][curIndex];
        }

        // memoize number of ways to make amount from a particular curIndex
        
        memo[amount][curIndex] = makeChange(amount - coins[curIndex], coins, curIndex) +
            makeChange(amount, coins, curIndex + 1);

        return memo[amount][curIndex];
    }

    public int change(int amount, int[] coins) {
        memo = new int[amount+1][coins.length];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        if (amount == 0) {
            return 1;
        }
        return makeChange(amount, coins, 0);
    }
}
