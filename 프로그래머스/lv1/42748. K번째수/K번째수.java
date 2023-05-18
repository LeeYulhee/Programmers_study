import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            answer[i] = findNumber(array, commands[i]);
        }
        return answer;
    }
    
    public static int findNumber(int[] array, int[] command) {
        int start = command[0] - 1;
        int end = command[1] - 1;
        int pick = command[2] - 1;

        int[] temp = new int[end - start + 1];

        for(int i = 0; i < temp.length; i++) {
            temp[i] = array[start];
            start++;
        }

        Arrays.sort(temp);

        return temp[pick];
    }
}