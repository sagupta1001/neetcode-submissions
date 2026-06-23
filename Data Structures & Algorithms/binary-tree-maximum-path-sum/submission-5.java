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

 // Step 1: Problem
 // Input: root = [1,2,3]
 // Output: 6
 // Path: [2, 1, 3]
 // Input: root = [-15,10,20,null,null,15,5,-5]
 // Output: 40
 
 // Step 2: Approach
 // Figure out the paths
 // Start from root
 // Inorder, Preorder, Post order traversals
 // Inorder / Postorder based on the example
 // Keep track of maximum sum so far

 // Step 3: Pseudo code
 // At every node, we want to get the max path sum of left subtree
 // and right subtree.
 // if current node is null then return 0
 // 
 // Left subtree max path is Max (0, left path sum) -> getMax(root.left)
 // Right subtree max path is Max (0, right path sum) -> getMax(root.right)
 // Current node path sum is current node val + left subtree max path + right substree max path
 // check if current path sum is greater than global max path sum and update


 // Example
 // input: [1]
 // return 1

 // Input: root = [1,2,3]
 // pseudo code works for [1,2,3]
 // Input: root = [-15,10,20,null,null,15,5,-5]
 // 




class Solution {
    
    int globalMaxPathSum = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSubtreeMaxPath = Math.max(0, dfs(root.left));
        int rightSubtreeMaxPath = Math.max(0, dfs(root.right));

        int currentNodePathSum = root.val + leftSubtreeMaxPath + rightSubtreeMaxPath;

        globalMaxPathSum = Math.max(globalMaxPathSum, currentNodePathSum);

        return root.val + Math.max(leftSubtreeMaxPath, rightSubtreeMaxPath);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMaxPathSum;
    }
}
