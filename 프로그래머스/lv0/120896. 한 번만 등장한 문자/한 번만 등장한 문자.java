import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        Arrays.sort(str);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length; i++) {
            int count = 0;
            for(int j = 0; j < str.length; j++) {
                if(str[i].equals(str[j])) {
                    count ++;
                }
            }
            if(count < 2) {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}