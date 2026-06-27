class Solution {
    // Problem:
    // Return the minimum number of intervals to remove
    // so that rest of intervals are non-overlapping
    // Input: intervals = [[1,2],[2,4],[1,4]]
    // Output: 1

    // Approach:
    // Iterate through the array and at each element 
    // decide whether to keep it or not. Regardless
    // we need to check if the intervals are non-overlapping.
    // For e.g.
    // [1,2] -> Keep we see that it overlaps with [1,4]
    // [1,2] -> remove we see that [2,4] still overlaps with [1,4]
    // same with [2,4]
    // with [1,4] -> keep it the it overlaps
    // with [1,4] we remove it then the full array is non-overlapping
    // this algorithm is like O(N^2) range roughly because for each element
    // we need to then check the rest of the array if it is non-overlapping
    // we can potentially look to sort the array first
    // based on the comparator that checks start_i's first. if they are the same
    // then checks end_i's.
    // so the input above would become
    // [[1,2],[1,4],[2,4]]
    // after sorting

    public int eraseOverlapIntervals(int[][] intervals) {
        // first sort the input intervals based on end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
            } else {
                count++;
            }
        }

        // then keep interval
        return count;

    }
}
