class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        return getString(s).equals(getString(t));
    }
    private String getString(String s){
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch =  s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch, i);
               
            }
            sb.append(Integer.toString(hm.get(ch)));
            sb.append("-");
        }
        return sb.toString();
    }
}