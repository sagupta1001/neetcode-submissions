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

// problem
// valid binary search tree
// left subtree has nodes with less than node 
// right subtree has nodes with keys greater than node
// both left and right are also valid BSTs

// approach
// recursive
// if root.left.val < root.val && root.right.val > root.val 
// && isValidBST(root.left) && isValidBST(root.right)
class Solution {

    //    0
    // -1000 1000
    //         0
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long left, long right) {
        if (node == null) return true;

        if (!(left < node.val && node.val < right)) {
            return false;
        }

        return valid(node.left, left, node.val) && valid(node.right, node.val, right);
    }
}
