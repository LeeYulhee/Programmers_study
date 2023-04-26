import java.util.*;

class Solution {
    public List solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int oneCounter = 0;
        int twoCounter = 0;
        int threeCounter = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) oneCounter ++;
            if(answers[i] == two[i % two.length]) twoCounter ++;
            if(answers[i] == three[i % three.length]) threeCounter ++;
        }

        List<Integer> answer = new ArrayList<>();

        if(oneCounter >= twoCounter && oneCounter >= threeCounter) answer.add(1);
        if(twoCounter >= oneCounter && twoCounter >= threeCounter) answer.add(2);
        if(threeCounter >= oneCounter && threeCounter >= twoCounter) answer.add(3);
        
        return answer;
    }
}