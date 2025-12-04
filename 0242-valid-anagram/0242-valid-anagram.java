class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hs1 = new int[26];
        int[] hs2 = new int[26];
        for(char ch : s.toCharArray()){
            hs1[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            hs2[ch - 'a']++;
        }
        return Arrays.equals(hs1, hs2);
    }
}