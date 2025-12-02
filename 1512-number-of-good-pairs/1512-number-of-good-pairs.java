class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n : nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for(Integer freq : hm.values()){
            count += ( freq * (freq - 1) ) / 2;
        }
        return count;
    }
}