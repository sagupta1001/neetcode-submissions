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


// approach
// find out number of linked lists
// create a new linked list
// iterate through all head of the lists and find the smallest value node
// while head of atleast one list is not null 
// - ignore that list if head of a list is null 
// - consider only lists where head is non-null
// - add the smallest value node to the new linked list
// - update head of that list from which the element was taken 

// improved approach using min heap
// add all heads of the linked lists to a min heap
// create a ListNode "current" = new Node
// create a ListNode "dummy" = new Node
// dummy.next = current
// while min heap not empty
// - minNode = pop the min heap
// - current.val = min value
// - current.next = new Node
// - current = current.next
// - minHeap->insert (minNode.next)

// return dummy.next


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            minHeap.add(head);
        }

        ListNode current = new ListNode();
        ListNode dummy = current;
        while (minHeap.size() != 0) {
            ListNode min = minHeap.poll();
            current.next = min;
            current = current.next;
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return dummy.next;
    }
}
