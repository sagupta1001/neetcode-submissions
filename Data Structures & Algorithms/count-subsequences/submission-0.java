class Solution {
    // problem
    // return number of distinct subsequences  of s
    // which are equal to t

    // approach
    // dynamic programming, but start with with recursion first

    // focus on a single letter in sth index
    // if that letter not equal to single letter in t th index
    // - increment sth index
    // if that letter equal to single letter in t th index
    // - increment sth index and t th index
    // - increment sth index

    // if letter equal to t th last + 1 
    // - return 1 
    // if letter equal to sth last + 1 
    // - return 0

    // recursive function returns the number of ways to generate
    // t from s
    // int dfs(s, t, sIndex, tIndex) 

    private int[][] dp;

    private int dfs(String s, String t, int sIndex, int tIndex) {
        if (tIndex == t.length()) {
            dp[sIndex][tIndex] = 1;
            return 1;
        }

        if (sIndex == s.length()) {
            dp[sIndex][tIndex] = 0;
            return 0;
        }

        if (dp[sIndex][tIndex] != -1) {
            return dp[sIndex][tIndex];
        }

        if (s.charAt(sIndex) != t.charAt(tIndex)) {
            dp[sIndex][tIndex] = dfs(s, t, sIndex+1, tIndex);
            return dp[sIndex][tIndex]; 
        }
        dp[sIndex][tIndex] = dfs(s, t, sIndex+1, tIndex+1) + dfs(s, t, sIndex+1, tIndex);

        return dp[sIndex][tIndex];
    }

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(s, t, 0, 0);
    }
}
