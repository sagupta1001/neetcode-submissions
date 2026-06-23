/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Problem: Return a deep copy of a graph (connected undirected graph)
// node contains an integer value and a list of neighbours
// Input is a Node
// 1-indexed
// Input: adjList = [[2],[1,3],[2]]
// Input in the function is a Node
// From a graph build a cloned graph

// Constraints: 
// 0 <= The number of nodes in the graph <= 100.
// output can be an array of size 101. Where each index will be an array of neighbours

// Approach:
// Traversal of the graph (depth-first) using a stack
// with a visited map of integer to node

// Pseudo code:







class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }

        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }

        return copy;
    }
}