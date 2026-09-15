class Solution {
    // problem
    // find minimum in rotated sorted array
    
    // minimum in sorted array is O(1) because its 
    // the first element
    // when rotated 1 time
    // brings the last element to the first
    // when rotated K times
    // brings the last K elements to the first

    // the minimum will be a drop in the array
    // binary search approach
    // instead of searching for an element
    // we find the mid
    // and check if the mid is greater than 
    // start and less than end

    // [3,4,5,6,1,2]
    //  0 1 2 3 4 5
    // mid = 2, start=0, end=5
    // mid = 3, start=2, end=5
    // mid = 4, start=3, end=5
    // start=3, end=4
    // basically because end < mid
    // start < mid i.e. not in the first half
    // we adjust the start to be mid
    // else 
    // start > mid
    // end = mid
    // termination seems to be if start within 1 of end
    public int findMin(int[] nums) {
        int numsLength = nums.length;
        int startIndex = 0, endIndex = numsLength - 1;
        int midIndex = 0;

        while (startIndex < endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            if (nums[endIndex] < nums[midIndex]) {
                startIndex = midIndex;
            } else {
                endIndex = midIndex;
            }
            if (startIndex == endIndex - 1) {
                return Math.min(nums[startIndex], nums[endIndex]);
            }
        }

        return nums[midIndex];
    }
}
