class Solution {
    public int search(int[] nums, int target) {
        return findInRotatedArray(nums, 0, nums.length - 1, target);
    }

    // Example: [4, 5, 6, 7, 0, 1, 2]
    public int findInRotatedArray(int[] nums, int start, int end, int target) {
        // Base case must come before calculating/accessing mid
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // Check whether the left half is sorted
        if (nums[start] <= nums[mid]) {

            // Check whether target lies inside the sorted left half
            if (nums[start] <= target && target < nums[mid]) {
                return findInRotatedArray(nums, start, mid - 1, target);
            }

            return findInRotatedArray(nums, mid + 1, end, target);
        }

        // Otherwise, the right half is sorted

        // Check whether target lies inside the sorted right half
        if (nums[mid] < target && target <= nums[end]) {
            return findInRotatedArray(nums, mid + 1, end, target);
        }

        return findInRotatedArray(nums, start, mid - 1, target);
    }
}