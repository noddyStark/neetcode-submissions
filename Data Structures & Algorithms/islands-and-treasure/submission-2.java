class Solution {
    public void islandsAndTreasure(int[][] grid) {
        /* Input:
    [2147483647,    -1,                 0,              2147483647],
    [2147483647,    2147483647,         2147483647,         -1],
    [2147483647,    -1,                 2147483647,         -1],
    [0,             -1,                 2147483647,         2147483647]


Output: [
    [3,     -1,     0,       1],
    [2,      2,     1,      -1],
    [1,     -1,     2,      -1],
    [0,     -1,     3,       4]
            ]

    R
    D
    L
    U
*/
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure chests as starting points.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[] {row, col});
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                    continue;
                }

                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}