class Solution {
    Map<String, List<String>> hm = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(hm.containsKey(s)) return hm.get(s);
          if (s.isEmpty()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
               String suffix = s.substring(word.length());
                  List<String> suffixWays = wordBreak(suffix, wordDict);
                  for(String way : suffixWays){
                    String sentence = word + (way.isEmpty() ? "" : " " + way);
                      result.add(sentence);
                  }
            }

        }
        hm.put(s, result);
        return result;
    }
}