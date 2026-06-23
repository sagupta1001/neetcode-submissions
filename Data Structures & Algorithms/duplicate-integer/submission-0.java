class Solution {
    public boolean hasDuplicate(int[] nums) {
        // iterate through each number 
        // if the number already exists in the hash set then return true
        // else add to hash set

        HashSet<Integer> trackUniqueNumbers = new HashSet<>();
        for (int num : nums) {
            if (trackUniqueNumbers.contains(num)) {
                return true;
            } else {
                trackUniqueNumbers.add(num);
            }

        }
        // outside of the loop return false
        return false;
    }
}