class Solution {
    // problem
    // find all triplets that sum to zero

    // approach
    // backtracking

    // dfs (int[] nums, int currIndex, int currSum, int currCount, int[] currTriplet)
    // if currSum == 0 && currCount == 3
    // - add currTriplet to global list of lists and return 

    // if currIndex == nums.length
    // - we could not find a triplet and return

    // - pick the current index num from nums and continue the dfs with the remaining array, 
    // - do not pick the current number and continue the dfs with the remaining array

    // Sort the array first
    // Iterate through array
    // Fix a number (current index), and then find two numbers that sum to minus the fixed number
    // to find two numbers in the rest of the array
    // - put a number into a hash set
    // - increment to next num, check if num1 + num2 = target
    // - check if target - num2 is in the hash set, if yes then return 
    // - num2, num1 and -target


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            List<Integer> possibleTriplet = new ArrayList<>();
            possibleTriplet.add(nums[i]);
            int target = -nums[i];

            HashSet<Integer> twoSum = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                if (twoSum.contains(target - nums[j])) {
                    possibleTriplet.add(target - nums[j]);
                    possibleTriplet.add(nums[j]);
                    if (!resSet.contains(possibleTriplet)) {
                        res.add(possibleTriplet);
                        resSet.add(possibleTriplet);
                    }
                    possibleTriplet = new ArrayList<>();
                    possibleTriplet.add(nums[i]);
                }
                twoSum.add(nums[j]);
            }
        }

        return res;
    }
}
