class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++ ){
                if(r == 0 || c == 0){
                    grid[r][c] = 1;
                } else {
                    grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}