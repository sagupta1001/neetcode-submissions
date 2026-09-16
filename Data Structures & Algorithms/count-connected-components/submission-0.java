class Solution {
    // undirected graph of n nodes
    // 0 to n-1 labelling

    // approach
    // union set?

    public int countComponents(int n, int[][] edges) {
        // create an adjacency list data structure
        List<List<Integer>> adj = new ArrayList<>();
        // create a sublist for each node to track its neighbours
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // for each edge we update the adjacency list 
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(adj, visit, nei);
            }
        }
    }
}
