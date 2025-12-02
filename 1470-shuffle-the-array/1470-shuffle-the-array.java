class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int idx = 0;
        for(int i = 0 ; i < nums.length ; i+=2){
            ans[i] = nums[idx];
            ans[i + 1] = nums[idx + n];
            idx++;
        }
        return ans;
    }
}