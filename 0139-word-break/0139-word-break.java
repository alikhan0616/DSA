class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0 ; i <= s.length() ; i++){
            if(dp[i]){
                for(String word : wordDict){
                    int n = word.length();
                    if(i + n <= s.length()){
                        if(s.substring(i, i + n).equals(word)){
                            dp[i + n] = true;
                        }
                    }
                }
            }
        }
        for(boolean b : dp){
            System.out.println(b);
        }
        return dp[s.length()];
    }
}