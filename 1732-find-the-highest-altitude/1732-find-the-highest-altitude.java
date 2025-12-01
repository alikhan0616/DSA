class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currAlt = 0;
        for(int i = 0 ; i < gain.length ; i++){
            currAlt += gain[i];
            maxAlt = Math.max(currAlt, maxAlt);
        }
        return maxAlt;
    }
}