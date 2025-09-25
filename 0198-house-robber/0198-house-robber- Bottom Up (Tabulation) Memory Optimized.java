class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2 ; i < nums.length ; i++){
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }
}