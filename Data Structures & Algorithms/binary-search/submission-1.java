class Solution {
    public int search(int[] nums, int target) {
        // [-1, 0, 2, 4, 6, 8]
        // target = 4

        int result = binarySearch(nums, target, 0, nums.length - 1);

        return result;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        // Base case: search range is empty
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        System.out.println("start = " + start + " mid = " + mid + " end = " + end
            + " nums[mid] = " + nums[mid] + " target = " + target);

        if (nums[mid] == target) {
            return mid;
        }

        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return binarySearch(nums, target, start, mid - 1);
        }
    }
}
