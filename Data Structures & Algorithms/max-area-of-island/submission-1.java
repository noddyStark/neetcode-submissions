class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, row, col));
                }
            }
        }

        return maxArea;
    }
    
    // Time complexity: O(rows × cols)
    // Space complexity: O(rows × cols) for visited and potentially the recursion stack.
    public int dfs(int[][] grid, boolean[][] visited, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        return 1
            + dfs(grid, visited, row, col + 1) // right
            + dfs(grid, visited, row, col - 1) // left
            + dfs(grid, visited, row - 1, col) // up
            + dfs(grid, visited, row + 1, col); // down

    }
}
