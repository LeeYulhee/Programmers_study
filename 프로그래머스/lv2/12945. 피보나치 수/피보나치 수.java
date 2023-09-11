import java.util.*;

class Solution { 
    public int solution(int n) {        
        int answer = 1;
        int answerBefore = 0;
        
        for(int i = 2; i <= n; i++) {
            int temp = answer;
            answer = (answer + answerBefore) % 1234567;
            answerBefore = temp;
        }
        
        return answer;
        
    }
}