class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZeros = 0;
        int prod = 1;

        for (int num : nums) {
            if (num == 0) {
                numZeros++;
            } else {
                prod *= num;
            }
        }

        if (numZeros > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (numZeros > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}  
