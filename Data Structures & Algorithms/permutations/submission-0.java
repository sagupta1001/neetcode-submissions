class Solution {
    // problem
    // return all permutations of input array

    // approach
    // pick a start index
    // pick the next index (random)
    // and so on
    // but how to determine which index to pick when..?

    // recursion + hash set to keep track of numbers

    // pseudo code
    // dfs(int[] nums, )
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, Set<Integer> used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (used.contains(num)) {
                continue;
            }
            current.add(num);
            used.add(num);

            backtrack(nums, current, used);

            used.remove(num);
            current.remove(current.size() - 1);
        }

        return;
    }
}
