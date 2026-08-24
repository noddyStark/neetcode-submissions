class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> mergedInterval = new ArrayList<>();
        int n = intervals.length;

        int i = 0;

        /*
         * ------------------3----------5---------------------
         * -----------------------4----------8----------------
         * ----------------------------------------10-----12--

         -------1----2----------------------------
        */
        while (i < n && intervals[i][1] < newInterval[0]) {
            mergedInterval.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        mergedInterval.add(newInterval);

        while (i < n) {
            mergedInterval.add(intervals[i]);
            i++;
        }

        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}