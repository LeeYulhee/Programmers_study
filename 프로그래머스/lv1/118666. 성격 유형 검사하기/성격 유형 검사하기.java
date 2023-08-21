import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> choicesMap = new HashMap<>();
        
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(char c : type) {
            choicesMap.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i++) {
            int changeScore;
            if(choices[i] == 4) {
                continue;
            }
            if(choices[i] < 4) {
                changeScore = (choices[i] - 4) * - 1;
                choicesMap.put(survey[i].charAt(0), choicesMap.get(survey[i].charAt(0)) + changeScore);
            } else {
                changeScore = choices[i] - 4;
                choicesMap.put(survey[i].charAt(1), choicesMap.get(survey[i].charAt(1)) + changeScore);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < type.length; i += 2) {
            char type1 = type[i];
            char type2 = type[i + 1];
            if(choicesMap.get(type1) >= choicesMap.get(type2)) {
                sb.append(type1);
            } else {
                sb.append(type2);
            }
        }
        
        return sb.toString();
    }
}