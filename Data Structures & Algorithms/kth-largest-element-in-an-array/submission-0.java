class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Offset allows negative numbers to be stored.
        int[] frequency = new int[max - min + 1];

        for (int num : nums) {
            frequency[num - min]++;
        }

        int counter = 0;

        for (int i = frequency.length - 1; i >= 0; i--) {
            counter += frequency[i];

            if (counter >= k) {
                return i + min;
            }
        }

        return -1; // Unreachable when k is valid.
    }
}