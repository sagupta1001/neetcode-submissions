class Solution {
    // problem
    // return maximum amount of money that can
    // be robbed without alerting police
    // you cannot rob two adjacent houses

    // houses are in a straight line
    // i'th integer represents the amount of money
    // from 0 to N-1 houses, i.e. total N houses

    // e.g. 
    // [1,1,3,3]
    // total=4
    // [2,9,8,3,6]
    // total=16

    // approach
    // trying out different combinations of the houses
    // with constraints but that's not efficient
    // we'd try by skipping one, then skipping two etc
    // with initial as 0 or 1st index

    // break this down
    // at each house there is a decision
    // to rob or not to rob
    // if i rob the ith house then i can rob the i+2th house
    // if i skip the ith house then i can rob the i+1th house

    // use recursion with the above somehow
    // keep track of a max sum (likely globally)


    // 
    // pseudo code

    private int[] memo;

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(nums, i+1), nums[i] + dfs(nums, i+2));
        return memo[i];
    }

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }
}
