class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1, 2, 4, 6
        /*
        For each index get the left prodcuct and get the right prodcut
        and multiply both in the end
        */

        int[] answer = new int[nums.length];

        answer[0] = 1;

        // Calculation Left Product
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // answer = [1, 1, 2, 8]

        int rightProduct = 1;

        // answer = [1, 1, 2, 8]
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct; // 2 * 6
            rightProduct = rightProduct * nums[i]; // 6
        }

        return answer;
    }
}
