class Solution {
    public boolean isPalindrome(String s) {
        String word = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int l = 0 , r = word.length() - 1;
        while(l < r){
            if(word.charAt(l) != word.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}