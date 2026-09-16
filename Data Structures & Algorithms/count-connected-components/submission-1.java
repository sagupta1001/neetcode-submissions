
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    public int find(int node) {
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return false;
        if (rank[pv] > rank[pu]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }
}
class Solution {
    // undirected graph of n nodes
    // 0 to n-1 labelling

    // approach
    // union set?

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                res--;
            }
        }

        return res;
        // // create an adjacency list data structure
        // List<List<Integer>> adj = new ArrayList<>();
        // // create a sublist for each node to track its neighbours
        // for (int i = 0; i < n; i++) {
        //     adj.add(new ArrayList<>());
        // }
        // // for each edge we update the adjacency list 
        // for (int[] edge : edges) {
        //     adj.get(edge[0]).add(edge[1]);
        //     adj.get(edge[1]).add(edge[0]);
        // }
        // boolean[] visit = new boolean[n];
        // int res = 0;
        // // traverse from each node and count components 
        // // when we encounter a new unvisited node
        // for (int node = 0; node < n; node++) {
        //     if (!visit[node]) {
        //         dfs(adj, visit, node);
        //         res++;
        //     }
        // }
        // return res;
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
