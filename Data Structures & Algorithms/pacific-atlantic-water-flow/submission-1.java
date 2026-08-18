class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean[][] visited = new boolean[rows][cols];

                // oceans[0] = Pacific
                // oceans[1] = Atlantic
                boolean[] oceans = new boolean[2];

                dfs(
                    heights,
                    row,
                    col,
                    heights[row][col],
                    visited,
                    oceans
                );

                if (oceans[0] && oceans[1]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(
        int[][] heights,
        int row,
        int col,
        int previousHeight,
        boolean[][] visited,
        boolean[] oceans
    ) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Invalid cell
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // Water cannot flow uphill
        if (heights[row][col] > previousHeight) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        // Top or left border touches the Pacific.
        if (row == 0 || col == 0) {
            oceans[0] = true;
        }

        // Bottom or right border touches the Atlantic.
        if (row == rows - 1 || col == cols - 1) {
            oceans[1] = true;
        }

        // No need to continue once both are reachable.
        if (oceans[0] && oceans[1]) {
            return;
        }

        int currentHeight = heights[row][col];

        dfs(heights, row, col - 1, currentHeight, visited, oceans);
        dfs(heights, row, col + 1, currentHeight, visited, oceans);
        dfs(heights, row - 1, col, currentHeight, visited, oceans);
        dfs(heights, row + 1, col, currentHeight, visited, oceans);
    }
}