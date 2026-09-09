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

// problem
// find minimum number of meeting rooms required
// to schedule all meetings without conflicts


// example
// [(0,40), (5, 10), (15, 20)]
// answer is 2

// approach
// assume sorted by start times, if not sort it
// if start time is less than previous time then increment number 
// of rooms

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;

            if (!rooms.isEmpty() && start >= rooms.peek()) {
                rooms.poll();
            }

            rooms.offer(end);
        }

        return rooms.size();
    }
}
