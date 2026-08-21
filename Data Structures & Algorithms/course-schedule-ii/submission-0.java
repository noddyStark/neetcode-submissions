class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        /*
        1 -> 0
        2 -> 1
        0 -> 2

        2 -> 1 -> 0
        |---<-----|  
        */

        ArrayList<ArrayList<Integer>> adjacencyList = createAdjacencyList(numCourses, prerequisites);
        int[] indegree = createIndegreeArray(numCourses, adjacencyList);

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int processedCourses = 0;

        while(!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;
            result.add(course);

            for (int nextCourse : adjacencyList.get(course)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i ++) {
            resultArray[i] = result.get(i);
        }

        return processedCourses == numCourses ? resultArray : new int[0];

    }


    private ArrayList<ArrayList<Integer>> createAdjacencyList(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] courses : prerequisites) {
            int preq = courses[1];
            int course = courses[0];

            adjacencyList.get(preq).add(course);
        }

        return adjacencyList;

    }

    private int[] createIndegreeArray(int numCourses, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] indegree = new int[numCourses];

        for (int u = 0; u < numCourses; u++) {
            for (int v : adjacencyList.get(u)) {
                indegree[v]++;
            }
        }

        return indegree;
    }
}
