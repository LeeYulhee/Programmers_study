import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int sLength = s.length();
        
        if(sLength % 2 == 1) return 0;
        
        for(int i = 0; i < sLength; i++) {
            
            Stack<Character> stack = new Stack<>();
            int check = 0;
            
            for(int j = 0; j < sLength; j++) {
                char temp = s.charAt((i + j) % sLength);
                if(temp == '[' || temp == '(' || temp == '{') {
                    stack.push(temp);
                } else {
                    if(stack.isEmpty()) break;
                    
                    char stackChar = stack.peek();
                    
                    if((stackChar == '[' && temp == ']') || (stackChar == '(' && temp == ')') || (stackChar == '{' && temp == '}')) {
                        stack.pop();
                        check++;
                        continue;
                    } else {
                        stack.push(temp);
                        break;
                    }
                }
            }
            
            if(check == (int)Math.ceil(sLength / 2)) {
                answer++;
            }
        }
        
        
        return answer;
    }
}