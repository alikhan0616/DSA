class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);
            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return min;
    }
}