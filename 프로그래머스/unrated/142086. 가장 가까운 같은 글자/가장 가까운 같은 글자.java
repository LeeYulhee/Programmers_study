class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(0, i));
            sb.reverse();
            int a = sb.indexOf(String.valueOf(s.charAt(i)));
            if ( a == -1) {
                answer[i] = -1;
            } else {
                answer[i] = a + 1;
            }
        }
        return answer;
    }
}