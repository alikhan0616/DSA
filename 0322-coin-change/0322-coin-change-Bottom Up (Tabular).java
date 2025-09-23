class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i <= amount ; i++){
            for(int coin : coins){
                int subProb = i - coin;
                if(subProb >= 0 && dp[subProb] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[subProb] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}