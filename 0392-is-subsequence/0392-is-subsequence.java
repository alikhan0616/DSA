class Solution {
    public boolean isSubsequence(String s, String t) {
        int ptr1 = 0, ptr2 = 0;
        int count = 0;
        while(ptr2 < t.length() && count != s.length()){
            if(s.charAt(ptr1) == t.charAt(ptr2)){
                count++;
                ptr1++;
            }
            ptr2++;
        }
        return count == s.length();
    }
}