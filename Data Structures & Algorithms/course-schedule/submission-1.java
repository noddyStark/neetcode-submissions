class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjacencyList =
            createAdjacencyList(numCourses, prerequisites);

        int[] indegreArray = createIndegreeArray(numCourses, adjacencyList);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegreArray[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCourses = 0;

        // BFS
        while (!queue.isEmpty()) {

            int course = queue.poll();
            processedCourses++;

            for (int nextCourse : adjacencyList.get(course)) {
                indegreArray[nextCourse]--;

                if (indegreArray[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // boolean[] visited = new boolean[numCourses];
        // boolean[] inRecursion = new boolean[numCourses];

        // for (int i = 0; i < numCourses; i++) {
        //     if (!visited[i] && hasCycleDFS(i, adjacencyList, visited, inRecursion)) {
        //         return false;
        //     }
        // }

        return processedCourses == numCourses;
    }

    public boolean hasCycleDFS(int u, ArrayList<ArrayList<Integer>> adjacencyList,
        boolean[] visited, boolean[] inRecursion) {
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

    private int[] createIndegreeArray(int numCourses, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] indegreeArray = new int[numCourses];

        for (int u = 0; u < numCourses; u++) {
            for (int v : adjacencyList.get(u)) {
                indegreeArray[v]++;
            }
        }

        return indegreeArray;
    }
}
