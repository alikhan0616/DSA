class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for(String str : strs){
            int[] freqArr = new int[26];
            for(char ch : str.toCharArray()){
                freqArr[ch - 'a']++;
            }
            String ref = Arrays.toString(freqArr);
            hm.putIfAbsent(ref, new ArrayList<>());
            hm.get(ref).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}