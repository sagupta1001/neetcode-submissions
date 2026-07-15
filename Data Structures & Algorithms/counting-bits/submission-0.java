class Solution {
    // Problem
    // 0 < n < 1000
    // for every integer from 0 to N (i.e N+1 is the size of the output array)
    // output number of 1's in the binary representation

    // Approach
    // lets say n = 0
    // then binary representation is 0, and output is [0]
    // for n = 1
    // again we need to get binary representation, and then do some
    // binary logic to get number of 1's
    // so perhaps we start from zero and iterate up to N
    // and for each number we do some binary logic

    // DP
    // zero -> 0
    // one -> 1
    // two (EVEN) -> 1
    // three -> 2
    // four (EVEN) -> 1
    // five (101) -> 2
    // six -> 2
    // seven (111) -> 3
    // eight (EVEN) -> 1

    // number of bits for i is i>>1 + i & 1
    // base cases 0 is zero
    // 1 is 1
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;

        if (n < 1) {
            return dp;
        }
        dp[1] = 1;

        if (n < 2) {
            return dp;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i&1);
        }

        return dp;
    }
}
