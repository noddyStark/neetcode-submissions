class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;

        // Add all initially rotten oranges to the queue.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = {
                {1, 0},  // down
                {0, 1},  // right
                {-1, 0}, // up
                {0, -1}  // left
        };

        int totalMinutes = 0;

        /*
         * Each iteration of this while-loop represents one minute.
         *
         * Continue only while:
         * 1. Fresh oranges still exist.
         * 2. There are rotten oranges available to spread the rot.
         */
        while (!queue.isEmpty() && freshOranges > 0) {
            int levelSize = queue.size();

            // Process all oranges that are rotten at the current minute.
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                        continue;
                    }

                    // We can only rot a fresh orange.
                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    freshOranges--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }

            // All oranges in this BFS level rot during the same minute.
            totalMinutes++;
        }

        // If fresh oranges remain, they were unreachable.
        return freshOranges == 0 ? totalMinutes : -1;
    }
}