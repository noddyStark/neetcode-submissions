/*
Treat each array index as a node, and its value as the index of the next node

nums = [1,2,3,2,2]
index:  0 1 2 3 4
value:  1 2 3 2 2

The movements are:
0 -> 1 -> 2 -> 3 -> 2 -> 3 -> 2 ...

There is a cycle:
2 -> 3 -> 2
The beginning of the cycle is 2, which is also the duplicate number.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // 1
        int fast = nums[nums[0]]; // 2

        // Find where slow and fast meet
        while (slow != fast) {
            slow = nums[slow]; // 2
            fast = nums[nums[fast]]; // 2
            System.out.println("slow = " + slow + " fast = " + fast);
        }
            System.out.println("slow = " + slow + " fast = " + fast);

        /*
        0 -> 1 -> 2 -> 3 -> 2 -> 3 -> 2
             s    f
                  s.        f
        */

        // Find the beginning of the cycle
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
