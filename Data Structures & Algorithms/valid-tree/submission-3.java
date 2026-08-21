class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(n, edges);

        boolean[] visited = new boolean[n];

        // Start from only one node.
        if (bfsCycle(adjacencyList, visited, 0)) {
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

    public boolean bfsCycle(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int u) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{u , -1});
        visited[u] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];

            for (int neighbour : adjacencyList.get(node)) {

                if (neighbour == parent) {
                    continue;
                }

                if (visited[neighbour]) {
                    return true;
                }

                visited[neighbour] = true;
                queue.offer(new int[]{neighbour, node});
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