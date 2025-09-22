class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxFreq = 0;
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i , 0) + 1);
            maxFreq = Math.max(hm.get(i), maxFreq);
        }
        int count = 0;
        for(int i : hm.values()){
            if(i == maxFreq) count++;
        }
        return maxFreq * count;

    }
}