class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> hs = new HashSet<>();
        int l = 0, res = 0;
        for(int r = 0 ; r < s.length() ; r++){
            if(hs.contains(s.charAt(r))){
                while(hs.contains(s.charAt(r))){
                    hs.remove(s.charAt(l));
                    l++;
                }
            }

            int size = (r - l) + 1;
            res = Math.max(size, res);
            hs.add(s.charAt(r));
        }
        return res;
    }
}