import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] order = new int[numlist.length];
        int num = 0;
        int[] answer = new int[numlist.length];

        for(int i : numlist) {
            order[num] = Math.max(n, i) - Math.min(n, i);
            num++;
        }

        Arrays.sort(order);


        for(int i = 0; i < numlist.length; i++) {
            if(i != 0 && order[i] == order[i-1]) answer[i] = n - order[i];
            else {
                for(int j : numlist) {
                    if(j == (n + order[i])) {
                        answer[i] = n + order[i];
                        break;
                     } else answer[i] = n - order[i];
                }
            }
        }
        return answer;
    }
}