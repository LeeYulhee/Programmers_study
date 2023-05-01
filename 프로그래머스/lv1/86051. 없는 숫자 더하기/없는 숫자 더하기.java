import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int[] allNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : numbers) {
            list.add(i);
        }

       for(int i : allNumbers) {
            if(!list.contains(i)) {
                answer += i;
            }
       }
        return answer;
    }
}