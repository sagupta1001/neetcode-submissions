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
    // problem
    // given the root of a binary tree, invert the tree and return its
    // root

    // approach
    // essentially for a node we want to invert the right node to be 
    // the left node, and do this for every node

    // could be done recursively
    // base case is if root is null or does not have left or right then return it
    // temp = root.right
    // root.right = invertTree(left)
    // root.left = invertTree(temp)

    // return root;


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        if (root.left == null && root.right == null) return root;

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }








    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
        
    //     if (root.right != null && root.left == null) {
    //         root.left = invertTree(root.right);
    //         root.right = null;
    //     } else if (root.left != null && root.right == null) {
    //         root.right = invertTree(root.left);
    //         root.left = null;
    //     }
    //     if (root.right != null && root.left != null) {
    //         TreeNode temp = root.right;
    //         root.right = root.left;
    //         root.left = temp;
    //         root.left = invertTree(root.left);
    //         root.right = invertTree(root.right);
    //     }
            
    //     return root;

    // }
}
