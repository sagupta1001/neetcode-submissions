class Solution {
    // problem
    // return an edge that can be removed so that the graph
    // is still connected but no cycles
    // return the edge that appears last if multiple answers

    // approach
    // there was an algorithm (not djikstra's) that helped find a cycle
    // perhaps we lead with that?


    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(par, rank, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[0];
        // int n = edges.length;
        // List<List<Integer>> adj = new ArrayList<>();

        // for (int i = 0; i <= n; i++) {
        //     adj.add(new ArrayList<>());
        // }

        // for (int[] edge: edges) {
        //     int u = edge[0], v = edge[1];
        //     adj.get(u).add(v);
        //     adj.get(v).add(u);

        //     boolean[] visit = new boolean[n+1];

        //     if (dfs(u, -1, adj, visit)) {
        //         return edge;
        //     }
        // }

        // return new int[0];
    }

    private int find(int[] par, int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[1];
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        // if (visit[node]) {
        //     return true;
        // }

        // visit[node] = true;
        // for (int nei : adj.get(node)) {
        //     if (nei == parent) {
        //         continue;
        //     }
        //     if (dfs(nei, node, adj, visit)) {
        //         return true;
        //     }
        // }
        // return false;
        return false;
    }
}
