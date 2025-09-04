class Solution {
    public int findClosest(int x, int y, int z) {
        int diffX = Math.abs(z - x);
        int diffY = Math.abs(z - y);
        if(diffX == diffY) return 0;
        return diffX < diffY ? 1 :  2;
    }
}