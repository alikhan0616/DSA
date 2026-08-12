class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1, res = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int hour = 0;
            for(int pile : piles){ 
                hour += Math.ceil((double) pile / mid );
            }

            if(hour <= h){
                res = Math.min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}