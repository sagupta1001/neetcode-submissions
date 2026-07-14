/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

 // Problem
 // Given an array of meeting time intervals in any
 // order find out if one can attend all meetings
 // return true if yes, and false if not

 // Approach
 // Sort the intervals based on start time
 // Iterate through interval and check if start time of current 
 // is less than end time of previous, if yes then return false
 // otherwise continue to the end. 
 // If reached end, then return true..

 // This is a greedy algorithm. we only need to compare adjacent
 // intervals because the list is now sorted. If the adjacent interval
 // does not overlap then the ones after cannot either.
 

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }

        return true;
    }
}
