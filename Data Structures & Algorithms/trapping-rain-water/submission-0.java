class Solution {
    public int trap(int[] height) {

        int maxHeightIndex = 0;
        int maxHeight = Integer.MIN_VALUE;
        int end = height.length - 1;

        for (int i = 0; i <= end; i++) {
            int currentHeight = height[i];

            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
                maxHeightIndex = i;
            }
        }

        int water = 0;

        // maxHeightIndex = 3

        int leftMax = height[0];
        for (int i = 1; i < maxHeightIndex; i++) {
            if (height[i] >= leftMax) {
                leftMax = height[i];
            } else {
                water = water + leftMax - height[i];
            }
        }

        int rightMax = height[end];
        for (int i = end - 1; i > maxHeightIndex; i--) {
            if (height[i] >= rightMax) {
                rightMax = height[i];
            } else {
                water = water + rightMax - height[i];
            }
        }

        return water;
    }
}
