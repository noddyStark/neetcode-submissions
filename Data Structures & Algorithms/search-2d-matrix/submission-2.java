class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int expectedRow = -1;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1; // 3 * 4 - 1 = 12 - 1 = 11

        // [1, 2, 4, 8, 10, 11, 12, 13, 14, 20, 30, 40]
        //  0  1  2  3   4   5   6   7   8   9  10  11

        while (high >= low) {

            int mid = low + (high - low) / 2; // mid = 5

            int row = mid / n; // row = 5 / 4 = 1
            int col = mid % n; // col = 5 % 4 = 1

            int value = matrix[row][col]; // value = 11

            if (target == value) { // 
                return true;
            }

            // target = 10, value = 11
            if (target > value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
