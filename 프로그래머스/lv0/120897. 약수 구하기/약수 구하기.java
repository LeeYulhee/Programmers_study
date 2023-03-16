import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        ArrayList <Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                list.add(i);
            }
        }

        int[] answer = list.stream()
	        .mapToInt(Integer::intValue)
    	    .toArray();
        
        return answer;
    }
}