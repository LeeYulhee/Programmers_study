import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        char lastLetter = words[0].charAt(words[0].length() - 1);
        int turn = 0;
        
        Set<String> word = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            int talker = i % n + 1;
            turn = i / n + 1;
            
            if ((i != 0 && lastLetter != words[i].charAt(0)) || word.contains(words[i]))  {
                return new int[]{talker, turn};
            }

            word.add(words[i]);
            
            lastLetter = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}