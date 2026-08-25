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
    public int minMeetingRooms(List<Interval> intervals) {
        /*
        -0-----------------40---------------
        ----5--10--15--20-------------------

        -0-----------------40---------------
        ----5-----10------------------------
        ----------------15------20----------
        */

        if (intervals.size() == 0) {
            return 0;
        }

        if (intervals.size() == 1) {
            return 1;
        }

        Collections.sort(intervals, (a, b) -> (a.start - b.start));

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int maxRooms = 0;

        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            while(!minheap.isEmpty() && start >= minheap.peek()) {
                minheap.poll();
            }

            minheap.offer(end);
            maxRooms = Math.max(maxRooms, minheap.size());
        }


        return maxRooms;
    }
}
