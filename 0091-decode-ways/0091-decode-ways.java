class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(0, s, dp);
    }

    private int dfs(int i, String s, Map<Integer, Integer> dp){
        if(dp.containsKey(i)){
            return dp.get(i);
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        int res = dfs(i + 1, s, dp);

        if(i + 1 < s.length()){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if(ch1 == '1' || (ch1 == '2' && ch2 >= '0' && ch2 <= '6')){
                res += dfs(i + 2, s, dp);
            }
        }

        dp.put(i, res);
        return res;
    }
}