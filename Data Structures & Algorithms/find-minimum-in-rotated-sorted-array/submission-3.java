class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start) / 2;

        int minValue = Integer.MAX_VALUE;

        System.out.println("start = " + start + " mid = " + mid + " end = " + end);
        // start = 0 mid = 2 end = 5

        if (nums[start] < nums[end]) {
            return nums[start];
        }

        if (nums[start] <= nums[mid]) {
            // Left part is sorted, so minimum is strictly to the right of mid
            return findSmallestInSubArray(nums, mid + 1, end, minValue);
        } else {
            // Minimum can be at mid or somewhere to the left
            return findSmallestInSubArray(nums, start, mid, minValue);
        }
    }

    public int findSmallestInSubArray(int[] nums, int start, int end, int minValue) {

        if (end < start) {
            return minValue;
        }

        if (start == end) {
            return Math.min(minValue, nums[start]);
        }

        int mid = start + (end - start) / 2;

        minValue = Math.min(minValue, nums[mid]);

        System.out.println("start = " + start + " mid = " + mid + " end = " + end);

        if (nums[mid] <= nums[end]) {
            return findSmallestInSubArray(nums, start, mid, minValue);
        } else {
            return findSmallestInSubArray(nums, mid + 1, end, minValue);
        }
    }
}

/*

[3, 4, 5, 6, -1, 0, 1, 2]

[6, 1, 2]



[4, 5, 0]

*/
