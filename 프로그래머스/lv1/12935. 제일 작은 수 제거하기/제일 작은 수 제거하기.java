import java.util.*;

class Solution {
    public List solution(int[] arr) {
        int[] temp = arr.clone();
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(temp);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        if(set.size() == 1) {
            answer.add(-1);
            return answer;
        }

        for(int i : set) {
            if(temp[0] != i) {
                answer.add(i);
            }
        }
        return answer;
    }
}