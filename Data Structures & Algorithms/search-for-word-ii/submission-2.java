class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, row, col, root, result, visited);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int row, int col, TrieNode current, List<String> result,
        boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        // Invalid cell or already used.
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col]) {
            return;
        }

        char ch = board[row][col];
        int index = ch - 'a';

        // The current path is not a prefix of any word.
        if (current.children[index] == null) {
            return;
        }

        current = current.children[index];

        if (current.word != null) {
            result.add(current.word);

            current.word = null;
        }

        // Choose.
        visited[row][col] = true;

        // Explore.
        dfs(board, row + 1, col, current, result, visited);
        dfs(board, row - 1, col, current, result, visited);
        dfs(board, row, col + 1, current, result, visited);
        dfs(board, row, col - 1, current, result, visited);

        // Unchoose/backtrack.
        visited[row][col] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }

            current.word = word;
        }

        return root;
    }
}
