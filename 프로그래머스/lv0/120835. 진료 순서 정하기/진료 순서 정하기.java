import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] tmp = emergency.clone();
        int[] answer = new int[emergency.length];
        int index = 1;

        Arrays.sort(emergency);

        for(int i = emergency.length-1; i >= 0; i--){
            for(int j = 0; j < emergency.length; j++) {
                if(emergency[i] == tmp[j]) {
                    answer[j] = index;
                    index++;
                    break;
                }
            }
        }
        return answer;
    }
}