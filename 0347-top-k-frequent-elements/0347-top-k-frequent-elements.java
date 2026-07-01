class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> count : hm.entrySet() ){
            arr.add(new int[]{count.getValue(), count.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}