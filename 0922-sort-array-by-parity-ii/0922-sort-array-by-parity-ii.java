class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0,  right = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 0){
                res[left] = nums[i];
                left+= 2;
            } else {
                res[right] = nums[i];
                right+= 2;
            }
        }
        return res;
    }
}