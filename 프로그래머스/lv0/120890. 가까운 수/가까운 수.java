import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        int tmp = 0;
        
        Arrays.sort(array);

        for(int i = 1; i < array.length; i++) {
            if((n - array[tmp]) == 0) {
                answer = array[tmp];
                break;
            } else if (Math.abs(n - array[i]) < Math.abs(n - array[tmp])) {
                answer = array[i];
                tmp = i;
            } else if (Math.abs(n - array[i]) == Math.abs(n - array[tmp])) {
                answer = array[tmp];
            }
        }
        return answer;
    }
}