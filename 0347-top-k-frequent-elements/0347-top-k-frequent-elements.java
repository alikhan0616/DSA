class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> count : hm.entrySet() ){
            buckets[count.getValue()].add(count.getKey());
        }


        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1 ; i > 0 && index < res.length ; i--){
            for(int val : buckets[i]){
                res[index++] = val;
                if(index == k) return res;
            }
        }

        return res;
    }
}