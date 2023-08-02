import java.util.*;

class Solution {
    public int solution(String s) {
        
        String[] strArray = s.split("");
        Deque<String> strDeque = new ArrayDeque<>();
        
        for(String letter : strArray) {
            strDeque.add(letter);
        }
        
        int answer = 0;
        String x = strDeque.peek();
        int xCount = 0;
        int yCount = 0;
        
        while(strDeque.peek() != null) {
            if(xCount == yCount && xCount != 0) {
                answer++;
                x = strDeque.peek();
                xCount = 0;
                yCount = 0;
            }
            if(x.equals(strDeque.peek())) {
                xCount++;
                strDeque.poll();
            } else {
                yCount++;
                strDeque.poll();
            }
        }
        
        if(xCount != 0) {
            return answer + 1;
        }
        
        return answer;
    }
}