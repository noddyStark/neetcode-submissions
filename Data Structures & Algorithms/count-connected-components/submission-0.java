class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(n, edges);
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(adjacencyList, visited, i);
            }
        }
        return connectedComponents;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int u) {

        if (visited[u]) {
            return;
        }

        visited[u] = true;

        for (int v : adjacencyList.get(u)) {
            if (!visited[v]) {
                dfs(adjacencyList, visited, v);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> createAdjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
}
