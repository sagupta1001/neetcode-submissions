class Solution {
    // Problem
    // Array is rotated between 1 and N times
    // Find a target, -1 if not exist
    // All numbers are unique in nums

    // Approach
    // If array is not rotated, or zero times
    // then binary search
    // [1,2,3,4,5,6]
    // If array is rotated, then binary search
    // on its own does not work
    // [3,4,5,6,1,2]
    // finding 1, but its not on the left half.
    // check if target is greater than 0th element
    // and less than mid, then its in that half
    // else in the right half. The Pseudo code
    // will be more correct, refer to that.
    

    // Pseudo code
    // Left = 0, Right = N-1
    // While Left <= Right
    // - Find mid
    // - if target is at mid return
    // - check if left < mid then it is sorted
    // - if target is in sorted, then 
    // - right = mid - 1
    // 

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
