class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!valueToIndex.containsKey(target - nums[i])) {
                valueToIndex.put(nums[i], i);
            } else {
                return new int[]{valueToIndex.get(target - nums[i]), i};
            }
        }

        return null;
    }
}
