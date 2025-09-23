class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        Integer result = minimumCoinChange(coins, amount);
        return result == null ? -1 : result;
    }

    private Integer minimumCoinChange(int[] coins, int m){
        if(hm.containsKey(m)) return hm.get(m);
        if(m == 0){
            return m;
        } else {
            Integer answer = null;
            for(int coin: coins){
                int subProb = m - coin;
                if(subProb < 0) continue;
                Integer subAns =  minimumCoinChange(coins , subProb);
                if(subAns != null){
                    answer = minCompare(subAns + 1, answer);
                }
            }
            hm.put(m, answer);
                return answer;
        }
    }
    private Integer minCompare(Integer a , Integer b ){
        if(a == null){
            return b;
        } else if (b == null){
            return a;
        } else {
            return Math.min(a, b);
        }
    }
}