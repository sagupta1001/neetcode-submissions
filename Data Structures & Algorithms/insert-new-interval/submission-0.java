class Solution {
    // problem
    // insert a new interval into an existing list of sorted
    // intervals and non-overlapping so that the new list is sorted and
    // non-overlapping

    // approach
    // brute force
    // can this new interval be fit before the current interval
    // - if new interval end is less than current interval start
    // - this gives me a potential index to insert 
    // - then check if prior to potential index if there is an overlap
    // - to do that check if new interval start is greater than prior interval
    // - end
    // - if no overlap then insert the new interval as is in between
    // - current and prior
    // - if overlap then merge the current and prior
    // - also if no suitable index found, then current is last index and
    // - prior is second last index

    // pseudo code
    // create a res interval array
    // initial "newInterval" is the input new Interval
    // iterate through each interval
    // check for overlap
    // - if no overlap specifically if newInterval start > currentInterval.end then add to res
    // - if no overlap specifically if newInterval end < currentInterval.start then add to res
    // - if overlap then compute new start and end for the current
    // - - update the "newInterval" gets updated to the newly computed interval

    // return res
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (newInterval[1] < intervals[i][0]) {
                res.add(new int[]{newInterval[0], newInterval[1]});
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                for (int j = i+1; j < intervals.length; j++) {
                    res.add(new int[]{intervals[j][0], intervals[j][1]});
                }
                return res.toArray(new int[res.size()][2]);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        return res.toArray(new int[res.size()][2]);
    }
}
