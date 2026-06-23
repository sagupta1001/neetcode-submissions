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

 // Problem: remove the nth node from end of list
 // Input: head = [1,2,3,4], n = 2
 // Output: [1,2,4]
 // Input: head = [1,2], n = 2
 // Output: [2]

 // Approach: 
 // iterate through the linked list, find the length
 // [1,2,3,4]
 // length: 4
 // second iteration: find and remove the (4-2) + 1th element = 3rd element or 2nd indexed (0 index based)
 // Removal of a node
 // prev node -> node to remove -> next node
 // prev node -> next node.
 // edge case is if node to remove is head (0 index)
 // return head -> next

 // Pseudocode:
 // length is 0
 // while cur node is not null
 //  - increment length
 //  - cur node is cur node->next

 // length is calculated
 // compute 0 index based element to remove
 // length - n = 2 for e.g

 // startIndex = 0
 // if index to remove is 0
 // - return head.next
 
 // prev = null
 // curr = head

 // while (startIndex < elementToRemoveIndex)
 // - prev = curr
 // - curr = curr.next
 
 // prev.next = curr.next
 // return head



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int elementToRemoveIndex = length - n;

        if (elementToRemoveIndex == 0) {
            return head.next;
        }

        ListNode prev = null;
        current = head;

        int startIndex = 0;
        while (startIndex < elementToRemoveIndex) {
            prev = current;
            current = current.next;
            startIndex++;
        }

        prev.next = current.next;

        return head;
    }
}
