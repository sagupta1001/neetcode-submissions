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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{p, q});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0], node2 = nodes[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.add(new TreeNode[]{node1.right, node2.right});
            queue.add(new TreeNode[]{node1.left, node2.left});
        }

        return true;
        // if (p == null && q != null)
        //     return false;
        // if (p != null && q == null) {
        //     return false;
        // }
        // if (p == null && q == null) {
        //     return true;
        // }
        // return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
