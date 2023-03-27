import java.util.ArrayList;
import java.util.Arrays;

import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        ArrayList<String> str = new ArrayList<>(Arrays.asList(my_string.split("[^0-9]+")));
        
        str.removeAll(Arrays.asList(""));
        
        for(int i = 0; i < str.size(); i++) {
                answer += Integer.parseInt(str.get(i));
        }
        
        return answer;
    }
}