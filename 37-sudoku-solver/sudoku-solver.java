class Solution {
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // Step 1: record what's already placed
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '0';
                    rows[r][val] = true;
                    cols[c][val] = true;
                    boxes[boxIndex(r, c)][val] = true;
                }
            }
        }
        
        backtrack(board, 0, 0);
    }
    
    private boolean backtrack(char[][] board, int r, int c) {
        // moved past the last row -> whole board filled
        if (r == 9) return true;
        
        // move to next row when column overflows
        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c == 8) ? 0 : c + 1;
        
        // cell already filled, skip to next
        if (board[r][c] != '.') {
            return backtrack(board, nextR, nextC);
        }
        
        // try digits 1-9
        for (int val = 1; val <= 9; val++) {
            int box = boxIndex(r, c);
            if (rows[r][val] || cols[c][val] || boxes[box][val]) {
                continue; // conflict, skip this digit
            }
            
            // place it
            place(board, r, c, val, true);
            
            if (backtrack(board, nextR, nextC)) {
                return true; // solution found downstream, propagate success
            }
            
            // undo (backtrack)
            place(board, r, c, val, false);
        }
        
        return false; // no digit worked here, trigger backtracking upstream
    }
    
    private void place(char[][] board, int r, int c, int val, boolean isPlacing) {
        board[r][c] = isPlacing ? (char) (val + '0') : '.';
        boolean state = isPlacing;
        rows[r][val] = state;
        cols[c][val] = state;
        boxes[boxIndex(r, c)][val] = state;
    }
    
    private int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}