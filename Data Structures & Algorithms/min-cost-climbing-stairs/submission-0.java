class Solution {
    // Problem
    // Min cost of climbing stairs

    // Approach 
    // dynamic programming

    // 
    // Cost at i is Min between
    // - cost of taking ith step + min (dp cost at i-1, dp cost at i-2)
    // - cost at i-1 + min (dp cost at i-2, dp cost at i-3)

    // dp cost at 0th index is 
    // cost at 0
    // dp cost at 1st index is
    // cost at min (0th, 1st index)

    // cost at 2
    // 3 + 1 = 4
    // or 2

    // dp 1, 1

    // dp 1,1,2


    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < N; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[N-1], dp[N-2]);
    }
}
