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

// problem
// reorder linked list
// order should be based on the indices

// 0, n-1, 1, n-2, 2, n-3 etc
// given the head of a singly linked list

// [0, 1, 2, 3, 4, 5, 6]
// [0, 6, 1, 5, 2, 4, 3]

// keep the even index element as is

// reorder the nodes themselves

// find the mid node (via fast and slow pointer)
// reverse second half
// traverse and first and second halves


class Solution {

    private void reverseList(ListNode start, ListNode end) {

    }

    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        ListNode prev = null;

        slow.next = null;

        // detach second half and reverse it
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        // prev is the head of the second half
        // merge the two halves now
        ListNode firstHalfTmp = head;
        ListNode secondHalfTmp = prev;
        while (head != null && prev != null) {
            firstHalfTmp = head.next;
            head.next = prev;
            head = firstHalfTmp;
            secondHalfTmp = prev.next;
            prev.next = head;
            prev = secondHalfTmp;
        }


        // 0 -> 1 -> 2 -> 3
        // 1 -> 0
        // 
    }
}
