class Solution {
    // Problem
    // Return true if we can reach the last index
    // starting from index 0

    // Approach
    // DP or Recursion?
    // DP
    // Can i jump till index 0 -> Yes.
    // Can i jump till index 1 -> jump till index i-1 + 1
    // 

    // dp[0] = true
    // dp[i] = dp[j] == true && dp[j] + j >= i
    public boolean canJump(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];

        dp[0] = true;

        for (int i = 1; i < N; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N-1];
    }
}
