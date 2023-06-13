import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> highestScore = new ArrayList<>();

        for ( int i = 0; i < score.length; i++) {
            if(i < k) {
                highestScore.add(score[i]);
                Collections.sort(highestScore);
                answer[i] = highestScore.get(0);
            } else {
                if (highestScore.get(0) < score[i]) {
                    highestScore.set(0, score[i]);
                    Collections.sort(highestScore);
                    answer[i] = highestScore.get(0);
                } else {
                    answer[i] = highestScore.get(0);
                }
            }
        }
        return answer;
    }
}