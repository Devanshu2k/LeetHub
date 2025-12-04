class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, row, col, digit)) {
                            board[row][col] = digit;

                            if (solve(board)) 
                                return true;  // solved

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false;  // no digit fits → trigger backtrack
                }

            }
        }
        return true; // every cell is filled
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        
        // check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
            if (board[i][col] == digit) return false;
        }

        // check 3x3 box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == digit) return false;
            }
        }

        return true;
    }
}
