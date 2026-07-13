class Solution {
    public int largestRectangleArea(int[] heights) {
        /*

            █   █
            █   █
            █   █
            █   █     █
            █   █     █
            █   █ █ █ █
            █ █ █ █ █ █
            0 1 2 3 4 5



       For every Index, i want to know the right samller height's index and left smaller height's
       index.

       area = heights[i] * (rightSmallerIndex - leftSmallerIndex + 1);

        Right Smaller:
            If there is no right smaller hieght for a particular index, then we will take the last
       index, because in the above example imagine there is a height of 0 as the index 5 ends. So if
       we are standing at index 3, the right smaller Index becomes = 5.

        Left Smaller:
            If we are standing at index 3, the left smaller height is at index 1, so for any
       rectangle that we can consider to calculate the area can not include the index 1, but index 2
       can be considered, so for the left smaller index that can be the boundary for the index 3
       here would be index of height(1) + 1, which in this case will be (1+1)= 2

        */

        Stack<Integer> stack = new Stack<>();
        int length = heights.length;

        int[] leftSmallerIndex = new int[length];
        int[] rightSmallerIndex = new int[length];

        // Left Smaller
        for (int i = 0; i < length; i++) {
            int currentHeight = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftSmallerIndex[i] = 0;
            } else {
                leftSmallerIndex[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();

        // Right Smaller
        for (int i = length - 1; i >= 0; i--) {
            int currentHeight = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmallerIndex[i] = length - 1;
            } else {
                rightSmallerIndex[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            int height = heights[i];
            int width = rightSmallerIndex[i] - leftSmallerIndex[i] + 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
