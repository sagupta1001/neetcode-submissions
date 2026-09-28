class Solution {
    // Sept 28
    // problem
    // given an array of integers and an integer target
    // return the indices i and j such that
    // nums[i] + nums[j] == target and i != j

    // constraint is that i, j exist
    // return i < j

    // approach
    // N^2 is brute force
    // store all numbers in a hash map (number to index)
    // then iterate again and check if the complement exists 
    // at a different index

    // wont work because duplicate numbers at different indices
    // cannot be supported in a hash map, we could have a list of 
    // indices but that's seems overly complex for now

    // hash map with number to frequency stored
    // then iterate again, first decrement the hash map's frequency
    // then check if the complement exists


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (complementMap.containsKey(complement)) {
                return new int[]{complementMap.get(complement), i};
            }
            complementMap.put(nums[i], i);
        }

        throw new Error("target not found");
    }
}
