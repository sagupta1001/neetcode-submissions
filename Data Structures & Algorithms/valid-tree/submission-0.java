class Solution {
    // problem
    // check if a graph is a valid tree

    // properties to check
    // no cycles
    // there is graph algorithm for this i forget the name (not djikstras, the other popular one)
    // and union find could work here too
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.components() == 1;
        // List<List<Integer>> adjList = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     adjList.add(new ArrayList<>());
        // }

        // for (int i = 0; i < edges.length; i++) {
        //     adjList.get(edges[i][0]).add(edges[i][1]);
        //     adjList.get(edges[i][1]).add(edges[i][0]);
        // }

        // Set<Integer> visit = new HashSet<>();
        // if (!dfs(0, -1, visit, adjList)) {
        //     return false;
        // }

        // return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) {
            return false;
        }
        visit.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }

    class DSU {
        int[] Parent, Size;
        int comps;

        public DSU(int n) {
            comps = n;
            Parent = new int[n+1];
            Size = new int[n+1];
            for (int i = 0; i <= n; i++) {
                Parent[i] = i;
                Size[i] = 1;
            }
        }

        public int find(int node) {
            if (Parent[node] != node) {
                Parent[node] = find(Parent[node]);
            }
            return Parent[node];
        }

        public boolean union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return false;
            comps--;
            if (Size[pu] < Size[pv]) {
                Size[pv] += Size[pu];
                Parent[pu] = pv;
            } else {
                Size[pu] += Size[pv];
                Parent[pv] = pu;
            }
            return true;
        }

        public int components() {
            return comps;
        }
    }
}
