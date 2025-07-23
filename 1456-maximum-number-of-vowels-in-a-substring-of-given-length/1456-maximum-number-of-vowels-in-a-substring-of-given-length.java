class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int max = 0;
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
          int window_size = i - l + 1;
          if(window_size > k){
            if(checkVowel(s.charAt(l))) count--;
            l++;
          }
          if(checkVowel(s.charAt(i))) count++;

          max = Math.max(max, count);
        }
        return max;
    }

    private boolean checkVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        } 
        return false;
    }
}