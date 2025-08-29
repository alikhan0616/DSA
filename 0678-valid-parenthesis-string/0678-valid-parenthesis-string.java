class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                leftMin++;
                leftMax++;
            } else if(ch == ')'){
                leftMin--;
                leftMax--; 
            } else {
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0){
                return false;
            }
            if(leftMin < 0){
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}