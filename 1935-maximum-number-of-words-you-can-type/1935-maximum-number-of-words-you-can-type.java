class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        char[] hs = new char[26];
        for(char ch : brokenLetters.toCharArray()){
            hs[ch - 'a'] = 1;
        }

        int count = 0;
        String[] words = text.split(" ");

        for(String string : words){
            for(char ch : string.toCharArray()){
                if(hs[ch - 'a'] == 1){
                    count++;
                    break;
                }
            }
        }

        return words.length - count;

            

        }
    }
