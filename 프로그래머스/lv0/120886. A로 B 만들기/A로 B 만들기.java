import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        String[] strBefore = before.split("");
        String[] strAfter = after.split("");

        Arrays.sort(strAfter);
        Arrays.sort(strBefore);

        if (Arrays.equals(strAfter, strBefore)) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}