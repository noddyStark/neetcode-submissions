class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> mergedInterval = new ArrayList<>();

        for (int[] interval : intervals) {
            mergedInterval.add(interval);
        }

        mergedInterval.add(newInterval);

        Collections.sort(mergedInterval, (a, b) -> (a[0] - b[0]));
        /*

        ----[1----3]-[2---5]--[4----6]----------------------
        */
        int i = 0;

        while (i < mergedInterval.size() - 1) {
            int currentStartTime = mergedInterval.get(i)[0];
            int currentEndTime = mergedInterval.get(i)[1];

            int nextStartTime = mergedInterval.get(i + 1)[0];
            int nextEndTime = mergedInterval.get(i + 1)[1];

            if (currentEndTime >= nextStartTime) {
                mergedInterval.get(i)[1] = Math.max(currentEndTime, nextEndTime);
                mergedInterval.get(i)[0] = Math.min(currentStartTime, nextStartTime);
                mergedInterval.remove(i + 1);
            } else {
                i++;
            }
        }

        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}