class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // We discovered a new island
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islandCount++;
                    dfs(grid, visited, row, col);
                }
            }
        }

        return islandCount;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]
            || grid[row][col] == 0) {
            return;
        }

        // Stop at water or previously visited land
        if (grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;

        // Visit horizontally and vertically connected land
        dfs(grid, visited, row + 1, col); // down
        dfs(grid, visited, row - 1, col); // up
        dfs(grid, visited, row, col + 1); // right
        dfs(grid, visited, row, col - 1); // left
    }
}
