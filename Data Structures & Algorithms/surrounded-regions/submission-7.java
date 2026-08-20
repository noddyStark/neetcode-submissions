

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    boolean[] surrounded = {true, true, true, true};

                    List<int[]> region = new ArrayList<>();

                    dfs(board, row, col, visited, surrounded, region);

                    if (surrounded[0] && surrounded[1] && surrounded[2] && surrounded[3]) {
                        for (int[] cell : region) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, boolean[][] visited, boolean[] surrounded,
        List<int[]> region) {
        int rows = board.length;
        int cols = board[0].length;

        region.add(new int[] {row, col});
        visited[row][col] = true;

        // Process ArrayList like a queue.
        for (int i = 0; i < region.size(); i++) {
            int[] cell = region.get(i);

            int currentRow = cell[0];
            int currentCol = cell[1];

            if (currentRow == 0) {
                surrounded[0] = false;
            }

            if (currentCol == 0) {
                surrounded[1] = false;
            }

            if (currentCol == cols - 1) {
                surrounded[2] = false;
            }

            if (currentRow == rows - 1) {
                surrounded[3] = false;
            }

            addCell(board, currentRow + 1, currentCol, visited, region);

            addCell(board, currentRow - 1, currentCol, visited, region);

            addCell(board, currentRow, currentCol + 1, visited, region);

            addCell(board, currentRow, currentCol - 1, visited, region);
        }
    }

    private void addCell(
        char[][] board, int row, int col, boolean[][] visited, List<int[]> region) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        region.add(new int[] {row, col});
    }
}