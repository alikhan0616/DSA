class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        int multiple = k;
        for(int i : nums){
            hs.add(i);
        }

        while(hs.contains(multiple)){
            multiple += k;
        }

        return multiple;
    }
}