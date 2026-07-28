class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if(s2.length() < s1.length()) return false;
        if(s2.contains(s1)) return true;

        int[] hm1 = new int[26];
        int[] hm2 = new int[26];

        for(char ch : s1.toCharArray()){
            hm1[ch - 'a']++;
        }

        int l = 0, r = 0;
        while(r < s2.length()){
            if((r - l + 1) > s1.length()){
                hm2[s2.charAt(l) - 'a']--;
                l++;
            }

            hm2[s2.charAt(r) - 'a']++;

            if(Arrays.equals(hm2, hm1)) return true;

            r++;
        }
        return false;
    }
}