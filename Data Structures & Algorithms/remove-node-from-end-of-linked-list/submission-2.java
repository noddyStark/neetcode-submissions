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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode nodeBeforeNodeToBeRemoved = dummy;

        // Move to the node immediately before the target.
        for (int i = 0; i < length - n; i++) {
            nodeBeforeNodeToBeRemoved =
                nodeBeforeNodeToBeRemoved.next;
        }

        nodeBeforeNodeToBeRemoved.next =
            nodeBeforeNodeToBeRemoved.next.next;

        return dummy.next;
    }
}
