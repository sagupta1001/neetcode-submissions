class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int streak = 0;
                while (set.contains(cur)) {
                    streak++;
                    cur++;
                }

                res = Math.max(res, streak);
            }
        }

        return res;
    }
}
