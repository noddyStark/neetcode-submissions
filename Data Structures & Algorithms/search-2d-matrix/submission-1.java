class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int expectedRow = -1;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
                expectedRow = i;
                break;
            }
        }

        // Target does not fall within the range of any row
        if (expectedRow == -1) {
            return false;
        }

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = matrix[expectedRow][i];
        }

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int low, int high) {

        if (high >= low) {

            int mid = low + (high - low)/2;

            if (target == nums[mid]) {
                return true;
            }

            if (target > nums[mid]) {
                return binarySearch(nums, target, mid + 1, high);
            } else {
                return binarySearch(nums, target, low, mid - 1);
            }
        } else {
            return false;
        }
    }
}
