class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Map<String, List<String>> patternMap = new HashMap<>();
        for(String word : wordList){
            for(int i = 0 ; i < word.length(); i++){
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int res = 1;
        while(!q.isEmpty()){
            int qL = q.size();
            for(int i = 0 ; i < qL ; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return res;
                }
                for(int j = 0 ; j < word.length() ; j++){
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for(String nei : patternMap.getOrDefault(pattern, new ArrayList<>())){
                        if(!visited.contains(nei)){
                            visited.add(nei);
                            q.offer(nei);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}