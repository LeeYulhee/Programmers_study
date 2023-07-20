import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        Queue<Integer> queue = new LinkedList<>();

        for(int i : section) {
            queue.offer(i);
        }

        int paintLength = queue.poll() + m - 1;

        while(true) {
            if(queue.peek() == null) {
                break;
            }

            if(queue.peek() <= paintLength) {
                queue.poll();
            } else {
                paintLength = queue.poll() + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}