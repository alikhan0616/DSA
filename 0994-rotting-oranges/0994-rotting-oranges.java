class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] days = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
           Arrays.fill(days[i], Integer.MAX_VALUE);
        }
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 2){
                    dfs(i, j, grid,days, 0);
                }
            }
    }
    int max = 0;
    for(int i = 0 ; i < rows ; i++){
        for(int j = 0 ; j < cols ; j++){
            if(grid[i][j] == 1){
                if(days[i][j] == Integer.MAX_VALUE) return -1;
                max = Math.max(max, days[i][j]);
            }
        }
    }
    return max;
    }
    private void dfs(int i , int j, int[][] grid, int[][] days, int currentTime){
        int rows = grid.length, cols = grid[0].length;
        if(i < 0 || j < 0 || i == rows || j == cols || grid[i][j] == 0 || currentTime >= days[i][j]){
            return;
        }

        days[i][j] = currentTime;
        dfs(i + 1, j, grid, days, currentTime + 1);
        dfs(i -1 , j, grid, days, currentTime + 1);
        dfs(i , j + 1, grid, days, currentTime + 1);
        dfs(i , j - 1, grid, days, currentTime + 1);
    }
}