class Solution {
    public int maxArea(int[] heights) {

        int start = 0;
        int end = heights.length - 1;
        int maxWater = 0;

        while (start < end) {

            int startHeight = heights[start];
            int endHeight = heights[end];

            int width = end - start;

            int currentWater = Math.min(startHeight, endHeight) * width;
            maxWater = Math.max(currentWater, maxWater);

            if (startHeight < endHeight) {
                start++;
            }

            if (endHeight < startHeight) {
                end--;
            }

            if (startHeight == endHeight) {
                start++;
                end--;
            }

        }

        return maxWater;
        
    }
}
