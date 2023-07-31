import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] babblingList = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            for(String s : babblingList) {
                if(!babbling[i].contains(s + s)) {
                    babbling[i] = babbling[i].replace(s, " ");
                }
            }
            
            if(babbling[i].trim().equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}