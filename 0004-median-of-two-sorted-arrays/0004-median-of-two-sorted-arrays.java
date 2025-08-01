class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int n = n1 + n2;
        int left = (n + 1)/ 2;
        int low = 0;
        int high = n1;
        while(low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            //Left Side
            // First Array
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            // Second Array
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

            //Right Side
            // First Array
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            // Second Array
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 != 0){
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2){
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }

        }
    return 0.0;
    }
}