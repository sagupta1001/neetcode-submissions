// problem
// given int array return true if there is a duplicate

// approach
// use a hash set to keep track of numbers
// if a number already exists in the set then 
// return true

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> setOfNumbers = new HashSet<>();

        for (int num : nums) {
            if (setOfNumbers.contains(num)) {
                return true;
            }
            setOfNumbers.add(num);
        }

        return false;
    }
}