class Solution {
    public int[][] merge(int[][] intervals) {
        
        /*
        
        [[1,3],[1,5],[6,7], [3,4], [8, 10], [9, 11]]

        after sorting
        [[1,3], [1,5], [3,4], [6,7], [8, 10], [9, 11]]


        ___1_____3____________________________________________________
        ___1_______________5__________________________________________
        _______________________6________7______________________________
        _________3_____4_______________________________________________
        ______________________________________8__________10___________
        ___________________________________________9___________11_____

        
        ____[1____________5]__________[6________7_______8_____________11]__
        */

        List<int[]> sortedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            sortedIntervals.add(interval);
        }

        Collections.sort(sortedIntervals,(a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int prevStart = sortedIntervals.get(0)[0];
        int prevEnd = sortedIntervals.get(0)[1];

        for (int i = 1; i < sortedIntervals.size(); i++) {
            int currentStart = sortedIntervals.get(i)[0];
            int currentEnd = sortedIntervals.get(i)[1];

            if (currentStart <= prevEnd) {
                // Merge overlapping intervals
                prevEnd = Math.max(prevEnd, currentEnd);
                prevStart = Math.min(prevStart, currentStart);
            } else {
                // Previous merged interval is complete
                result.add(new int[]{prevStart, prevEnd});

                prevStart = currentStart;
                prevEnd = currentEnd;
            }
        }

        // Add the final merged interval
        result.add(new int[]{prevStart, prevEnd});

        return result.toArray(new int[result.size()][]);
    }
}
