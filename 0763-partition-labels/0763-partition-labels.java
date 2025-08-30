class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] indexes = new int[26];
        List<Integer> result = new ArrayList<>();

        // Counting last occurence of each character
        for(int i = 0 ; i < n ; i++){
            indexes[s.charAt(i) - 'a'] = i;
        }

        int size = 0, end = 0;
        for(int i = 0 ; i < n ; i++){
            size++;

            end = Math.max(end, indexes[s.charAt(i) - 'a']);

            if(i == end){
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}