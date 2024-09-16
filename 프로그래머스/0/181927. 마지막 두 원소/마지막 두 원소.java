import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        
        int length    = num_list.length;
        int lastNum   = num_list[length - 1];
        int beforeNum = num_list[length - 2];
        int[] answer = Arrays.copyOf(num_list, length + 1);
        
        answer[length] = lastNum > beforeNum ? lastNum - beforeNum : lastNum * 2;
        
        return  answer;
    }
}