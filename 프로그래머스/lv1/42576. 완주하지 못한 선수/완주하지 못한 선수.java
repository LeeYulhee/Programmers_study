import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        Deque<String> participantDeque = new ArrayDeque<>();
        Deque<String> completionDeque = new ArrayDeque<>();
        
        for(String s : participant) {
            participantDeque.add(s);
        }
        
        for(String s : completion) {
            completionDeque.add(s);
        }
        
        while(completionDeque.peek() != null) {
            if(participantDeque.peek().equals(completionDeque.peek())) {
                participantDeque.poll();
                completionDeque.poll();
            } else {
                answer = participantDeque.poll();
            }
        }
        
        if(participantDeque.peek() != null) {
            return participantDeque.poll();
        }
        
        return answer;
    }
}