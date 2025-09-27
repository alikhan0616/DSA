class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];

        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        grid[0][0] = 1;
        for(int r = 0 ; r < m ; r++){
            for(int c = 0; c < n ; c++){
                if(obstacleGrid[r][c] == 1){
                    grid[r][c] = 0;
                } else  {
                   grid[r][c] += (r > 0) ? grid[r - 1][c] : 0;
                   grid[r][c] += (c > 0) ? grid[r][c - 1] : 0;
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}