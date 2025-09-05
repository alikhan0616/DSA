class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDia = new HashSet<>();
        Set<Integer> negDia = new HashSet<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, n, cols, posDia, negDia, result, board);
        return result;
    }

    private void backtrack(int row, int n, Set<Integer> cols, Set<Integer> posDia, Set<Integer> negDia, List<List<String>> result, char[][] board){
        if(row == n){
            List<String> copy = new ArrayList<>();
            for(char[] r : board){
                copy.add(new String(r));
            }
            result.add(copy);
            return;
        }

        for(int c = 0 ; c < n ; c++){
            if(cols.contains(c) || posDia.contains(row + c) || negDia.contains(row - c)){
                continue;
            }

            cols.add(c);
            posDia.add(row + c);
            negDia.add(row - c);
            board[row][c] = 'Q';
            backtrack(row + 1, n, cols, posDia, negDia, result, board);
            cols.remove(c);
            posDia.remove(row + c);
            negDia.remove(row - c);
            board[row][c] = '.';


        }
    }
}