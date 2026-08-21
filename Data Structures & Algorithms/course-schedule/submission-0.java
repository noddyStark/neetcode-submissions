class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjacencyList =
            createAdjacencyList(numCourses, prerequisites);
        /*
        0 -> 1
        */

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];


        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycleDFS(i, adjacencyList, visited, inRecursion)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycleDFS(int u, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, boolean[] inRecursion) {

        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adjacencyList.get(u)) {
            if (!visited[v] && hasCycleDFS(v, adjacencyList, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        inRecursion[u] = false; 
        return false;
    }

    private ArrayList<ArrayList<Integer>> createAdjacencyList(
        int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 1 -> 0
        for (int[] courses : prerequisites) {
            int preq = courses[1]; // 1
            int course = courses[0]; // 0

            adjacencyList.get(preq).add(course);
        }

        return adjacencyList;
    }
}
