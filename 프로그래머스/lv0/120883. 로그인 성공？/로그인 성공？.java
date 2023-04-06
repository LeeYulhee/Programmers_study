import java.util.Arrays;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for(String[] str : db) {
            if (Arrays.equals(str, id_pw)) {
                answer = "login";
                break;
            } else if ( str[0].equals(id_pw[0]) && !str[1].equals(id_pw[1])) {
                answer = "wrong pw";
            }
        }
        return answer;
    }
}