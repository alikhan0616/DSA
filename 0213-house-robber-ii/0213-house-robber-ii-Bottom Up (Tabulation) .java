class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int[] skipFirstHouse = new int [nums.length - 1];
        int[] skipLastHouse = new int [nums.length - 1];

        for(int i = 0; i < nums.length - 1 ; i++){
            skipFirstHouse[i] = nums[i + 1];
            skipLastHouse[i] = nums[i];
        }

        int lootWithFirstHouse = getLoot(skipLastHouse);
        int lootWithLastHouse = getLoot(skipFirstHouse);

        return Math.max(lootWithFirstHouse, lootWithLastHouse);
    }

    private int getLoot(int[] nums){
        if(nums.length < 2){
            return nums[0];
        }

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