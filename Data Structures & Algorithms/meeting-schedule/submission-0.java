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

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
        --0----------------------------30----
        -----5-----10------------------------
        -----------------15----20-------------
        */

        if (intervals.size() == 1) {
            return true;
        }

        Collections.sort(intervals, (a, b) -> (a.start - b.start));

        for (int i = 1; i < intervals.size(); i++) {

            int previousStart = intervals.get(i-1).start;
            int previousEnd = intervals.get(i-1).end;

            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;

            if (currentStart >= previousEnd) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
