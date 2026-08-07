class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // Try every cell as the starting position.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (dfs(board, word, r, c, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int index, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }

        if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || visited[r][c]) {
            return false;
        }

        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        boolean found = dfs(board, word, r + 1, c, index + 1, visited) ||
                        dfs(board, word, r - 1, c, index + 1, visited) ||
                        dfs(board, word, r, c + 1, index + 1, visited) ||
                        dfs(board, word, r, c - 1, index + 1, visited);
        
        visited[r][c] = false;
        return found;
    }
}