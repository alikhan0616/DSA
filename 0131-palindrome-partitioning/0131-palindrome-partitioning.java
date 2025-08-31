class Solution {
    public List<List<String>> partition(String s) {
        List<String> part = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, part, result);
        return result;
    }

    private void dfs(int index, String s, List<String> part, List<List<String>> result){
        if(index >= s.length()){
            result.add(new ArrayList<>(part));
            return;
        }

        for(int j = index; j < s.length() ; j++){
            if(isPalindrome(index, j, s)){
                part.add(s.substring(index, j + 1));
                dfs(j + 1, s, part, result);
                part.remove(part.size() - 1);
            }

        }
    }

    private boolean isPalindrome(int l, int r, String s){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
           
        }
         return true;
    }
}