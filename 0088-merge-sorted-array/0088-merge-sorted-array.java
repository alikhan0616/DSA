class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0 , ptr2 = 0;
        int[] ans = new int[nums1.length];
        int idx = 0;
        while(ptr1 < m && ptr2 < n){
            if(nums1[ptr1] < nums2[ptr2]){
                ans[idx++] = nums1[ptr1++];
            } else {
                ans[idx++] = nums2[ptr2++];
            }
        }
        while(ptr1 < m){
            ans[idx++] = nums1[ptr1++];
        }
          while(ptr2 < n){
            ans[idx++] = nums2[ptr2++];
        }
        for(int i = 0 ; i < nums1.length ; i++){
            nums1[i] = ans[i];
        }

    }
}