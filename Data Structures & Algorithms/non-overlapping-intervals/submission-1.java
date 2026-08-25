class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        ----[1------2]---------[2-----4]------------
        ----[1-----------------------4]------------

        [1,2], [1,4], [2,4]
        */

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int totalRemovals = 0;

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < prevEnd) {
                totalRemovals++;
                prevEnd = Math.min(prevEnd, currentEnd);
            } else {
                prevStart = currentStart;
                prevEnd = currentEnd;
            }
        }

        return totalRemovals;
    }
}
