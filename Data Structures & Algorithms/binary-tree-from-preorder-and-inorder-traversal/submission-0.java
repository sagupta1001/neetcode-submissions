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
// preorder - first time visit a node (curr, left, right)
// inorder - BST (left, curr, right)

// Approach
// preorder - root is the first one
// inorder - leftmost
// [1,2,3,4]

// inorder divides the tree into left and right half
// e.g. [2,1,3,4]
// 2 is the left half
// 3,4 is the right half

// how to know the structure of the right half?
// maybe we repeat the same divide and conquer
// check the preorder to see which of the right half came first
// in the preorder, and that's the root.

// Pseudo code:
// Create the root node
// - find the root node value from pre order array (index 0)
// - find the index of the root node value in the in order array
// - 0..c (Left half) and (c+1..N-1) is the right half
// left half repeat the above process
// right half repeat the above process

class TreeNodeSplit {
    TreeNode node;
    int splitIndex;

    TreeNodeSplit(TreeNode node, int splitIndex) {
        this.node = node;
        this.splitIndex = splitIndex;
    }
}

class Solution {


    private TreeNodeSplit createNode(int[] preorder, int[] inorder) {
        int currNodeVal = preorder[0];
        int currNodeIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == currNodeVal) {
                currNodeIndex = i;
            }
        }

        TreeNode curr = new TreeNode(currNodeVal);

        return new TreeNodeSplit(curr, currNodeIndex);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);

        root.right = buildTree(rightPreorder, rightInorder);

        return root;
        // TreeNodeSplit nodeSplit = createNode(preorder, inorder);

        // System.out.println(nodeSplit.splitIndex);

        // // splitIndex - 1
        // // splitIndex + 1

        // // if both are out of bounds then exit

        // int leftSubtreeStartIndex = nodeSplit.splitIndex - 1;
        // int rightSubtreeStartIndex = nodeSplit.splitIndex + 1;

        // while(leftSubtreeStartIndex >= 0) {
        //     TreeNodeSplit leftSubtreeSplit = createNode(preorder, inorder);
        //     leftSubtreeStartIndex = leftSubtreeSplit.splitIndex - 1;
        // }

        // return nodeSplit.node;
    }
}
