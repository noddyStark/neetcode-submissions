class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(n, edges);

        boolean[] visited = new boolean[n];

        // Start from only one node.
        if (dfsCycle(adjacencyList, visited, 0, -1)) {
            return false;
        }

        // Every node must be reachable from node 0.
        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                return false;
            }
        }

        return true;
    }

    public boolean dfsCycle(
        ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int u, int parent) {
        visited[u] = true;

        for (int v : adjacencyList.get(u)) {
            if (v == parent) {
                continue;
            }

            if (visited[v]) {
                return true;
            }

            if (dfsCycle(adjacencyList, visited, v, u)) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<ArrayList<Integer>> createAdjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] nodes : edges) {
            int u = nodes[0];
            int v = nodes[1];

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        return adjacencyList;
    }
}