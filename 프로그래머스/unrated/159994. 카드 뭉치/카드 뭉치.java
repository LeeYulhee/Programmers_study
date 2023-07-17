import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        String answer = "Yes";

        Queue<String> queueCards1 = new LinkedList<>();

        for (String s : cards1) {
            queueCards1.offer(s);
        }

        Queue<String> queueCards2 = new LinkedList<>();

        for (String s : cards2) {
            queueCards2.offer(s);
        }

        for(int i = 0; i < goal.length; i++) {
            if (goal[i].equals(queueCards1.peek())) {
                queueCards1.poll();
            } else if (goal[i].equals(queueCards2.peek())) {
                queueCards2.poll();
            } else {
                return "No";
            }
        }
        
        return answer;
    }
}