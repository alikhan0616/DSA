class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] hs = new boolean[256];
        for(char ch : jewels.toCharArray()){
            hs[ch] = true;
        }
        int count = 0;
        for(char ch : stones.toCharArray()){
            if(hs[ch]) count++;
        }
        return count;

    }
}