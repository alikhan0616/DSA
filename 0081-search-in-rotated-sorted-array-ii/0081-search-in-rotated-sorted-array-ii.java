class Solution {
    public boolean search(int[] nums, int target) {
          int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (high + low) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[low]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[low] > nums[mid] ) {
                if(nums[high] >= target && nums[mid] < target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }
}