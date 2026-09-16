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
// binary tree so each node has up to two children
// return the level order traversal as a nested list
// from left to right

// approach
// usually a breath first traversal using a queue is used
// to traverse a tree 

// start by pushing the root of the tree to a queue
// numNodesInLevel = 1
// result list = []
// while the queue is not empty
// - pop the front of the queue
// - decrement numNodesInLevel

// - if numNodesInLevel is zero
// - - create a new sublist and add to it the front of the queue
// - else
// - - add front of queue to sublist
// - add its children to the back of the queue
// - for each non null child increment numNodesInLevel
// - create a sublist

// - when to know a sublist is done?

//  1
// 2 3

//   1
//  2
// 3 4
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            if (level.size() > 0) {
                res.add(level);
            }
        }

        return res;
    }
}
