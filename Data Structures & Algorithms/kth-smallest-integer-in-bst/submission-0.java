/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Problem
// find the kth smallest

// Approach
// inorder traversal of a BST 
// gives the sorted array
// from a sorted array we go to index K (1-based)

// but actually we may not need a sorted array
// intermediary if we smartly implement this

// inorder traversal
// left curr right
// we need to keep track of how many nodes have been "visited"
// and decrement a global counter K
// so leftmost will be visited first
// then current will be visited next
// then rightmost will be visited
// we keep visiting until the global counter is zero

class Solution {

    private int count;
    private int answer;

    private void inorder(TreeNode curr) {
        if (curr == null || count == 0) {
            return;
        }

        inorder(curr.left);
        count--;

        if (count == 0) {
            answer = curr.val;
            return;
        }

        System.out.println("Curr " + curr.val);

        inorder(curr.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return answer;
    }
}
