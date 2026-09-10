class Solution {
    // problem
    // merge all overlapping intervals and 
    // return non-overlapping intervals

    // approach
    // would sorting help? yup
    // by start time
    // because if start time is less than the previous end time
    // [1,10], [2,11], [3,7]
    // so previous here is the one with the largest end time so far when we are 
    // merging
    // then there is an overlap
    // [1,4], [2,3]
    // so sorting helps
    // now when we look at an interval
    // [1,4]
    // merge should take the max of the end times of the two intervals
    // being considered
    // if no overlap then keep the interval as is
    // we'll need a new interval result set


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] prevInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[0] > prevInterval[1]) {
                res.add(prevInterval);
                prevInterval = curInterval;
            } else {
                prevInterval[1] = Math.max(curInterval[1], prevInterval[1]);
            }
        }

        res.add(prevInterval);
        return res.toArray(int[][]::new);
    }
}
