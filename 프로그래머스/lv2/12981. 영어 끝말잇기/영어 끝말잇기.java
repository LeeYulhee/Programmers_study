import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        char lastLetter = words[0].charAt(words[0].length() - 1);
        int turn = 0;
        
        Map<String, int[]> word = new HashMap<>();
        
        for(int i = 0; i < words.length; i++) {
            int talker = (i + 1) % n == 0 ? n : (i + 1) % n;
            turn = i / n + 1;
            
            if (i != 0 && lastLetter != words[i].charAt(0)) {
                return new int[]{talker, turn};
            }
            
            if (word.get(words[i]) != null) {
                return new int[]{talker, turn};
            }
            
            word.put(words[i], new int[]{talker, turn});
            
            lastLetter = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}