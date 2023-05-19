class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(true) {
            int temp = n / a;
            n = temp * b + n % a;
            answer += temp * b;
            if (n < a) break;
        }
        return answer;
    }
}