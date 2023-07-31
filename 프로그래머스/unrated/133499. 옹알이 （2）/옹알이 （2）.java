import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] babblingList = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            for(String s : babblingList) {
                if(!babbling[i].contains(s + s) && babbling[i].contains(s)) {
                    babbling[i] = babbling[i].replace(s, "X");
                }
            }

            babbling[i] = babbling[i].replace("X", "");
            
            if(babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
}