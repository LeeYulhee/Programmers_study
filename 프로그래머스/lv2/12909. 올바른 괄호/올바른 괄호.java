import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Queue<Character> bracketQueue = new LinkedList<>();
        
        if(s.charAt(0) == ')') return false;
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                bracketQueue.add(c);
            } else {
                bracketQueue.poll();
            }
        }
        
        if(bracketQueue.isEmpty()) return true;

        return false;
    }
}