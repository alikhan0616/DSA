class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int target = 1 ; target <= n ; target++){
            for(int i = 1; i * i <= target ; i++){
                int square = i * i;
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[n];
    }
}