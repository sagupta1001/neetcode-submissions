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
    public ListNode reverseList(ListNode head) {
        // 0 -> 1 -> 2 -> 3
        // null <- 0

        // current -> 0
        // tmp -> 0
        // prev head = null

        // next = 1
        // tmp . next = prev head

        // current = next
        // next = current -> next

        if (head == null)
            return null;

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
