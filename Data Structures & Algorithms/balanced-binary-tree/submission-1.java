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

class Solution {
    // Problem: 
    // is height balanced binary tree or not
    // left and subtree of every node diffe in height by no more than 1

    // Approach:
    // Recursion
    // For every node we need to check
    // if Abs ( left subtree height - right sub tree ) <= 1
    //  return true
    // else 
    //  return false

    // Pseudo code:

    // if root.right && root.left both are null
    //  return true
    // if root.right 
    //   check if root.right is balanced
    // if root.left
    //   check if root.left is balanced

    // function to return the left and right subtree height
    // function to check if node is balanced



    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;
        Map<TreeNode, Integer> depths = new HashMap<>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int left = depths.getOrDefault(node.left, 0);
                    int right = depths.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;
                    depths.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }

        return true;
    }
}
