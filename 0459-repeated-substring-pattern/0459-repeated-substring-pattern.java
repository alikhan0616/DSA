class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = n / 2 ; i > 0 ; i--){
            if(n  % i == 0){
                int repeatedNum = n / i;
                String subString = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < repeatedNum ; j++){
                    sb.append(subString);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}