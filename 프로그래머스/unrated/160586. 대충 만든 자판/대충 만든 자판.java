import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> pushCountMap = new HashMap<>();
        
        for(String s : keymap) {
            for(int i = 0; i < s.length(); i++) {
                if(!pushCountMap.containsKey(s.charAt(i))) {
                    pushCountMap.put(s.charAt(i), i + 1);
                } else if (pushCountMap.get(s.charAt(i)) > i + 1) {
                    pushCountMap.put(s.charAt(i), i + 1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                if(!pushCountMap.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += pushCountMap.get(targets[i].charAt(j));
                }
            }
        }
        
        return answer;
    }
}