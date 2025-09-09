class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] hasVisited = new boolean[ROWS][COLS];
        for(int r = 0 ; r < ROWS ; r++){
            for(int c = 0 ; c < COLS ; c++){
                if(dfs(r, c, board, word, 0, hasVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, String word, int i , boolean[][] hasVisited){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || hasVisited[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }

        hasVisited[r][c] = true;
        boolean res = dfs(r + 1, c, board, word, i + 1, hasVisited) ||
        dfs(r - 1, c, board, word, i + 1, hasVisited) ||
        dfs(r, c + 1, board, word, i + 1, hasVisited) ||
        dfs(r, c - 1, board, word, i + 1, hasVisited);
        hasVisited[r][c] = false;

        return res;
    }
}