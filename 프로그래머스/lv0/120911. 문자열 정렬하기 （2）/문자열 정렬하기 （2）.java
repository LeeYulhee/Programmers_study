import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toLowerCase().toCharArray();
        Arrays.sort(arr);
        String answer = String.valueOf(arr);
        return answer;
    }
}