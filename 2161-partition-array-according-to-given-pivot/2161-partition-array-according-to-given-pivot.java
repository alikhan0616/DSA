class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int n = nums.length;
        int idx= 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot)
            res[idx++] = nums[i];
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == pivot)
            res[idx++] = nums[i];
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > pivot)
            res[idx++] = nums[i];
        }
        return res;
    }
}