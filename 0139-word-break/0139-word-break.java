class Solution {
    Map<String, Boolean> hm = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(hm.containsKey(s)) return hm.get(s);
        if(s.isEmpty()) return true;

        for(String word : wordDict){
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()), wordDict)){
                    hm.put(s, true);
                    return true;
                }
            }
        }
        hm.put(s, false);
        return false;
    }
}