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
// serialize into a string
// deserialize into a tree structure

// Approach
// BFS
// Use a queue
// serialize will return a string
// "1,2,3,null,null,4,5"


// deserialize takes the same string as input
// handle empty string by returning null 
// iterate through the string, first level i.e. root is of length 1
// second level will be of length 2
// third level will be of length 4 and so on
// initially put the root or the first element into the queue 
// Loop while queue not empty
// - pop the queue
// - get next two elements from serialized string
// - set left as the first element if not null
// - set right as the second element if not null
// - enqueue the two elements into queue (only the ones not null)


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Approach
        // BFS
        // Use a queue
        // serialize will return a string
        // "1,2,3,null,null,4,5"

        Queue<TreeNode> bfs = new LinkedList<>();
        StringBuilder serialOutput = new StringBuilder();

        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode curr = bfs.remove();

            if (curr == null) {
                serialOutput.append("null,");
                continue;
            } else {
                serialOutput.append(curr.val);
                serialOutput.append(",");
            }

            bfs.add(curr.left);
            bfs.add(curr.right);
        }

        System.out.println(serialOutput.toString());
        return serialOutput.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // deserialize takes the same string as input
        // handle empty string by returning null
         
        // iterate through the string
        // initially put the root or the first element into the queue 

        Queue<TreeNode> bfs = new LinkedList<>();
        String[] nodes = data.split(",");

        if (nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        int currIndex = 1;
        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode curr = bfs.remove();

            String left = nodes[currIndex];
            String right = nodes[currIndex+1];
            TreeNode leftNode = null;
            TreeNode rightNode = null;

            if (!left.equals("null")) {
                curr.left = new TreeNode(Integer.valueOf(left));
                bfs.add(curr.left);
            }
            if (!right.equals("null")) {
                curr.right = new TreeNode(Integer.valueOf(right));
                bfs.add(curr.right);
            }

            currIndex += 2;
        }
        // Loop while queue not empty
        // - pop the queue
        // - get next two elements from serialized string
        // - set left as the first element if not null
        // - set right as the second element if not null
        // - enqueue the two elements into queue (only the ones not null)
        return root;
    }
}
