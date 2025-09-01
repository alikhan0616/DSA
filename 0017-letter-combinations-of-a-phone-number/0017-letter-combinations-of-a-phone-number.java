class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        Map<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        backtracking(0, result, digits, hm, new StringBuilder());
        return result;
    }

    private void backtracking(int index, List<String> result, String digits, Map<Character, String> digitToChar, StringBuilder currStr){
        if(index == digits.length()){
            result.add(currStr.toString());
            return;
        }

        String possibleChars = digitToChar.get(digits.charAt(index));

        for(char ch: possibleChars.toCharArray()){
            currStr.append(ch);
            backtracking(index + 1, result, digits, digitToChar, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}