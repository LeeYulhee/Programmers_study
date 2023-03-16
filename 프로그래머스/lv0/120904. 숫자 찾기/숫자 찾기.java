class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String num1 = Integer.toString(num);
        String k1 = Integer.toString(k);
        if(num1.indexOf(k1) != -1) {
            answer = num1.indexOf(k1)+1;
        } else answer = -1;
        return answer;
    }
}