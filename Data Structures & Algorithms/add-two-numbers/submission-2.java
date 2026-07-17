/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        /*
        l1 = [1,2,3] this is from the digit 321

        l2 = [4,5,6] this is from the digit 654

        the sum is 975
        */

        while (l1 != null || l2 != null || carry != 0) {
            int l1Value = (l1 != null) ? l1.val : 0;
            int l2Value = (l2 != null) ? l2.val : 0;

            int sum = l1Value + l2Value + carry;

            int digit = sum % 10; // 5
            carry = sum / 10; // 0

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
