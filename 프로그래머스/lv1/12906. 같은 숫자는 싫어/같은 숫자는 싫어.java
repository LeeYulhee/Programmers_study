import java.util.*;

public class Solution {
    public List solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i : arr) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            int i = queue.poll();
            if(queue.peek() == null) {
                list.add(i);
            }
            else if(i == queue.peek()) {
                continue;
            } else {
               list.add(i);
            }
        }

        return list;
    }
}