class Solution {

    int[][] dirs = {
        {1, 0},   // down
        {1, -1},  // down-left
        {1, 1}    // down-right
    };

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        int[][] attacked = new int[n][n];

        backtrack(0, n, board, attacked, result);

        return result;
    }

    public void backtrack(
        int row,
        int n,
        char[][] board,
        int[][] attacked,
        List<List<String>> result
    ) {

        // All rows successfully filled
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (char[] boardRow : board) {
                current.add(new String(boardRow));
            }

            result.add(current);
            return;
        }

        // Try every position in this row
        for (int col = 0; col < n; col++) {

            // Queen cannot be placed here
            if (attacked[row][col] > 0) {
                continue;
            }

            // PLACE QUEEN
            board[row][col] = 'Q';

            // Mark attacked cells
            markAttacked(row, col, n, attacked, 1);

            // Go to next row
            backtrack(row + 1, n, board, attacked, result);

            // BACKTRACK
            markAttacked(row, col, n, attacked, -1);

            board[row][col] = '.';
        }
    }

    private void markAttacked(int row,int col, int n, int[][] attacked, int value) {

        for (int[] dir : dirs) {

            int newR = row + dir[0];
            int newC = col + dir[1];

            while (newR < n && newC >= 0 && newC < n) {

                attacked[newR][newC] += value;

                newR += dir[0];
                newC += dir[1];
            }
        }
    }
}