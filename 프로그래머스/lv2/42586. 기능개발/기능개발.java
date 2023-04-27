import java.util.*;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
           queue.add((100 - progresses[i] + (speeds[i]) - 1) / speeds[i]);
        }

        int day = queue.poll();
        int count = 1;
        int i = 0;

        while(!queue.isEmpty()) {
            if(day >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                list.add(count);
                day = queue.poll();
                count = 1;
            }
            if (queue.peek() == null) {
                list.add(count);
            }
        }
        return list;
    }
}