class Solution {
    // problem
    // heights represent the height of the ith bar
    // return max amount of water a container can store

    // approach
    // brute force is O(N^2) basically a nested for-loop
    // and keep track of area between the two bars
    // and return the max

    // two pointers
    // start at 0 and N-1
    // move the shorter one because that may increase
    // water
    // keep track of the max through this process and return 
    // the max once right == left
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxWater = -1;
        int curWater = -1;

        while (left < right) {
            curWater = (right - left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(curWater, maxWater);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
