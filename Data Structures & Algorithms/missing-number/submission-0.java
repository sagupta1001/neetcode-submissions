class Solution {
    // Problem
    // find missing number in [0,n]

    // approach
    // we know length of nums
    // if length is 3
    // then [0,3] is expected
    // sum expected is 3 * 4 / 2 = 6
    // iterate through nums and find actual sum
    // expected - actual sum is the missing number

    // [0,2]
    // expected sum = 3
    // actual sum = 2
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n+1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
