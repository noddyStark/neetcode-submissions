class Solution {
    public int findMin(int[] nums) {
        return findSmallestInArray(nums, 0, nums.length - 1);
    }

    public int findSmallestInArray(int[] nums, int start, int end) {
        // Only one element remains
        if (start == end) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;

        System.out.println(
            "start = " + start +
            " mid = " + mid +
            " end = " + end
        );

        if (nums[mid] > nums[end]) {
            /*
             * The minimum must be strictly to the right of mid.
             *
             * Example:
             * [4, 5, 6, 1, 2, 3]
             *        mid       end
             *
             * nums[mid] > nums[end]
             */
            return findSmallestInArray(nums, mid + 1, end);
        } else {
            /*
             * The minimum is either mid itself or somewhere to its left.
             *
             * Example:
             * [6, 1, 2, 3, 4, 5]
             *        mid       end
             *
             * nums[mid] < nums[end]
             */
            return findSmallestInArray(nums, start, mid);
        }
    }
}