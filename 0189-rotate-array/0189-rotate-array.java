class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int pivot = k % n;
        int[] ans = new int[n];
        for(int i = 0 ; i < nums.length ; i++){
            ans[(i + pivot) % n] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = ans[i];
        }
    }
}