class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols]; 
        boolean[][] atl = new boolean[rows][cols]; 

        for(int c = 0 ; c < cols ; c++){
            dfs(0, c, heights[0][c], heights, pac);
            dfs(rows - 1, c, heights[rows - 1][c], heights, atl);
        }
        for(int r = 0 ; r < rows ; r++){
            dfs(r, 0, heights[r][0], heights, pac);
            dfs(r, cols - 1, heights[r][cols - 1], heights, atl);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c< cols ; c++){
                if(pac[r][c] && atl[r][c]) result.add(Arrays.asList(r , c));
            }
        }
        return result;
    }
    private void dfs(int r , int c, int prevHeight, int[][] heights, boolean[][] visited){
        int rows = heights.length;
        int cols = heights[0].length;
        if(r < 0 || c < 0 || r == rows || c == cols || visited[r][c] || heights[r][c] < prevHeight){
            return;
        }
        visited[r][c] = true;
        dfs(r + 1 , c , heights[r][c], heights, visited);
        dfs(r - 1 , c , heights[r][c], heights, visited);
        dfs(r , c + 1 , heights[r][c], heights, visited);
        dfs(r  , c - 1 , heights[r][c], heights, visited);

    }
}