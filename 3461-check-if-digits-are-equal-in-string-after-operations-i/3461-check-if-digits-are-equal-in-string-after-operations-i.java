class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 2){
            for(int i = 0 ; i < sb.length() - 1; i++){
                int digit1 = sb.charAt(i) - '0';
                int digit2 = sb.charAt(i + 1) - '0';
                char sum = (char) (((digit1 + digit2) % 10) + '0');
                sb.setCharAt(i, sum);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if(sb.charAt(0) == sb.charAt(1)) return true;
        return false;
    }

}