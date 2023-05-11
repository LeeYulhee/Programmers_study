import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int plus = 0;
        int answer = 0;
        Arrays.sort(d);

        for(int i : d) {
            if (plus + i >  budget) {
                break;
            } else {
                plus += i;
                answer++;
            }
        }
        return answer;
    }
}