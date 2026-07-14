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
// Given the roots of two binary trees
// return true if there is a subtree of root 
// with the same structure and node values
// of subRoot

// Approach
// check root value and subroot value
// if not equal then check root value left and subroot value
// if equal then check root value left and subroot value left &&
// check root value right and subroot value right

// find nodes that could be start of the traversal first
// if root.value == subroot.value then check if root.left and subroot.left
// root.right and subroot.right are the same recursively.

// if root.value != subroot.value then check if root.left and subroot are subtrees
// or root.right and subroot are subtrees.

// base case: if root is null then return false


class Solution {  

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return root.val == subRoot.val &&
            isSameTree(root.left, subRoot.left) &&
            isSameTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean foundMatch = false;

        if (root.val == subRoot.val) {
            foundMatch = isSameTree(root.left, subRoot.left) && 
                    isSameTree(root.right, subRoot.right);
        }

        if (foundMatch) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
