class Solution {
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxCount = 0;
        for(int r = 0 ; r < rows ; r++ ){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == 1){
                    count = 0;
                    dfs(r , c , grid);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    private void dfs(int r, int c, int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || c < 0 || r == rows || c == cols || grid[r][c] != 1 ){
            return;
        }
        count++;
        grid[r][c] = 0;
        dfs(r + 1, c , grid);
        dfs(r - 1, c , grid);
        dfs(r, c + 1 , grid);
        dfs(r, c - 1 , grid);
    }
}