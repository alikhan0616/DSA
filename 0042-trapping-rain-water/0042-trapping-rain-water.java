class Solution {
    public int trap(int[] height) {
          if(height.length < 1) return 0;
        int res = 0, l = 0, r = height.length - 1, maxLeft = height[0], maxRight = height[height.length - 1];
        while(l < r){

            if(maxLeft < maxRight){
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }
        return res;
    }
}