class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                
                char ch = board[row][col];

                if (ch == '.') {
                    continue;
                }

                String rowKey = ch + " in row " + row;
                String colKey = ch + " in col " + col;
                String boxKey = ch + " in box " + row/3 + " - " + col/3;

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
                
            }
        }

        return true;
    }
}
