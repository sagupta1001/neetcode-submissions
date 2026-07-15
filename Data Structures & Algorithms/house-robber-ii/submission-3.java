class Solution {
    // Problem
    // return maximum amount that can be robbed
    // max 100 houses
    // max value at each house is 200

    // Approach
    // Break this down into sub problems
    // if one house, return the value 
    // if two houses, return the max value between the two
    // if three houses, 

    // need to keep track of adjacency when there are three or more houses
    // because we can't pick neighbours

    // for e.g. here the max is 4, but then we can't pick the 3 after
    // Input: nums = [3,4,3]
    // and neither can be pick 3 and 3 because its a circluar neighbourhood

    // perhaps we need to keep track of the max amount that can be robbed
    // up until the ith index
    // at index 0, its the value itself or max of the value so far
    // at index 1, its the max of the two values or max of the value so far

    // at index 2, check if its the last home (index N-1)
    // if not last index then its the value itself + max at (index N-3) OR max at (index N-4) 
    // if last index, then ensure to not check the first index

    // either we rob the current house and take the max at i-2 or skip the current house 
    // and take the max at i-1

    // so we can use the above approach and run it for houses 0 to n-2 or 1 to n-1 index

    public int rob(int[] nums) {
        int[] dpKeepFirst = new int[nums.length];
        int[] dpKeepLast = new int[nums.length];

        dpKeepFirst[0] = nums[0];
        if (nums.length == 1) return nums[0];
        dpKeepFirst[1] = Math.max(nums[0], nums[1]);

        dpKeepLast[0] = 0;
        dpKeepLast[1] = nums[1];

        for (int i = 2; i < nums.length - 1; i++) {
            dpKeepFirst[i] = Math.max(nums[i] + dpKeepFirst[i-2], dpKeepFirst[i-1]);
        }
        
        for (int i = 2; i < nums.length; i++) {
            dpKeepLast[i] = Math.max(nums[i] + dpKeepLast[i-2], dpKeepLast[i-1]);
        }

        return Math.max(dpKeepFirst[nums.length - 2], dpKeepLast[nums.length-1]);
    }
}
