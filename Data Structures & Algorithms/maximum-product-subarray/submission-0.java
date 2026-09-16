class Solution {
    // problem
    // find maximum product subarray

    // atleast one element in the array

    // pseudo code
    // max so far is Integer.MIN_VALUE
    // maxProductSoFar is 1
    // minProductSoFar is 1
    // iterate through array
    // - current
    // - if current < 0 resetMaxProductSoFar to 1
    // - else maxProductSoFar
    // - - current * maxProductSoFar if current > 0
    // - minProductSoFar
    // - - current * minProductSoFar
    // compare if any are greater than max so far and
    // update max so far based on that

    // return max so far
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
