class Solution {
    public int jump(int[] nums) {
        int jumps = 0, lastJumpIndex = 0, coverage = 0, destination = nums.length - 1;
        if(nums.length == 1) return 0;

        for(int i = 0 ; i < nums.length ; i++){
            coverage = Math.max(coverage, nums[i] + i);
            if(lastJumpIndex == i){
            lastJumpIndex = coverage;
            jumps++;
            if(coverage >= destination){
                return jumps;
            }
            }
        }
        return jumps;

    }
}