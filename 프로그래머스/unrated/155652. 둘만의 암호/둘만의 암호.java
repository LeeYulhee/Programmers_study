import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();

        List<Character> exceptSkipChar = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            char alphabet = (char)(97 + i);
            if(skip.indexOf(alphabet) != -1) {
                continue;
            }
            exceptSkipChar.add(alphabet);
        }

        for(char c : s.toCharArray()) {

            int findIndex = (exceptSkipChar.indexOf(c) + index) % exceptSkipChar.size();
            
            sb.append(exceptSkipChar.get(findIndex));
        }
        
        return sb.toString();
    }
}