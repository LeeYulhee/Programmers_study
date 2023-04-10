import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> origin = new ArrayList<>();
        int[] answer = new int[score.length];
        int num = 0;
        
        for(int[] i : score) {
            origin.add(i[0] + i[1]);
        }

        List<Integer> rank = new ArrayList<>(origin);
        rank.sort(Comparator.reverseOrder());

        for (int i = 0; i < origin.size(); i++) {
            if((i != 0 && origin.get(i-1) != origin.get(i)) || i == 0) num = rank.indexOf(origin.get(i)) + 1;
            answer[i] = num;
        }
        return answer;
    }
}