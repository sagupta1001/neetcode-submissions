class Solution {
    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(nums, target, currentCombination, 0);
        return combinations;
    }

    private void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            combinations.add(new ArrayList(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i+1);
    }


}
