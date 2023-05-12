class Solution {
    public String solution(String s, int n) {
        char[] arrCh = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : arrCh) {
            if(c >= 'A' && c <= 'Z') {
                if(c + n > 'Z')
                    sb.append(String.valueOf((char)('A' + (c + n - 91))));
                else
                    sb.append(String.valueOf((char)(c + n)));
            } else if(c >= 'a' && c <= 'z') {
               if(c + n > 'z')
                    sb.append(String.valueOf((char)('a' + (c + n - 123))));
                else
                    sb.append(String.valueOf((char)(c + n)));
            } else {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}