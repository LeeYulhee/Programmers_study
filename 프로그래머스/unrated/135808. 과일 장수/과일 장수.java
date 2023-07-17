import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int answer = 0;
        
        int[] deleteSmallNumber = new int[m * (score.length/m)];

        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);

        Arrays.sort(tmp, Collections.reverseOrder());

        for(int i = 0; i < deleteSmallNumber.length; i++) {
            deleteSmallNumber[i] = tmp[i];
        }

        Arrays.sort(deleteSmallNumber);

        for(int i = 0; i < deleteSmallNumber.length; i += m) {
            answer += deleteSmallNumber[i] * m;
        }
        
        return answer;
    }
}