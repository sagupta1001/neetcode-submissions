class Solution {
    // problem
    // return the integer that appears only once
    // or does not appear twice

    // approach
    // hash map
    // seen 3 before? 
    // - no? add to map
    // - yes? increment count
    // iterate over hash map entries
    // and return the key with value 1

    // we need O(1) extra space
    // and O(n) runtime

    // [1]
    // length 1 return the first element

    // [1,1,2]
    // [1,2,1]
    // [2,1,1]
    // length of array must be odd
    // XOR
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
