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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (a - b));

        for (ListNode node : lists) {
            while (node != null) {
                maxHeap.offer(node.val);
                node = node.next;
            }
        }

        ListNode head = null;

        if (!maxHeap.isEmpty()) {
            head = new ListNode(maxHeap.poll());
            ListNode dummy = head;

            while (!maxHeap.isEmpty()) {
                dummy.next = new ListNode(maxHeap.poll());
                dummy = dummy.next;
            }
        }

        return head;
    }
}
