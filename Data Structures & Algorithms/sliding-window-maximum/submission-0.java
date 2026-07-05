class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1, 2, 1, 0, 4, 2, 6

        // max = 2

        /*
        _______________
                 1 2    
        _______________
        
        */

        Deque<Integer> deQueue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            // i = 0,
            // i = 1, [0] 
            // i = 2, [1]
            while (!deQueue.isEmpty() && deQueue.peekFirst() <= i - k) {
                deQueue.pollFirst();
            }

            // if nums[i] > the number at the index present in the last of deque, we poll
            // basically we want to store bigger number, or we can say it monotnically decreasing
            // deque

            // i = 0
            // i = 1, deQueue => [0], but since nums[i] is 2, so we pop
            // i = 2, deQueue => [1], since nums[i] is 1, so we do not pop
            
            // Remove smaller elements from the end
            // because nums[i] is bigger and will be more useful for future windows
            while (!deQueue.isEmpty() && nums[deQueue.peekLast()] < nums[i]) {
                deQueue.pollLast();
            }

            // i = 0,deQueue => [0]
            // i = 1, index 0 was popped, and now we add index 1
            // i = 1, deQueue => [1]
            // i = 2, deQueue => [1, 2]
            deQueue.offerLast(i);

            if (i >= k - 1) {
                // the front of the deque stores the index of the maximum element for the current window.
                result[i - k + 1] = nums[deQueue.peekFirst()];
            }
        }

        return result;
    }
}
