import java.util.Arrays;

class Solution {
    public int[] solution(int[] array) {
        int[] tmp = array.clone();
        int[] answer = new int[2];

        Arrays.sort(tmp);
        answer[0] = tmp[tmp.length-1];
        
        for(int i = 0; i < array.length; i++){
            if(array[i] == tmp[tmp.length-1]) {
                answer[1] = i;
            }
        }
        return answer;
    }
}