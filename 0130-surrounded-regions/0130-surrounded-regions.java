class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0; r < ROWS ; r++){
            for(int c = 0 ; c < COLS ; c++){
                if(board[r][c] == 'O' && (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1)){
                    capture(board, r, c, ROWS, COLS);
                }
            }
        }

    

        for(int r = 0 ; r < ROWS ; r++){
            for(int c = 0 ; c < COLS ; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
            }
        }
         for(int r = 0 ; r < ROWS ; r++){
            for(int c = 0 ; c < COLS ; c++){
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
        
    }

    private void capture(char[][] board, int r, int c, int ROWS, int COLS){
        if(r == ROWS || c == COLS || r < 0 || c < 0 || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c, ROWS, COLS);
        capture(board, r - 1, c, ROWS, COLS);
        capture(board, r , c + 1, ROWS, COLS);
        capture(board, r , c - 1, ROWS, COLS);
    }


}