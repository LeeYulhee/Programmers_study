class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        int num = 1;

        while(true) {
            if(i > n) break;
            else if(num % 3 == 0 || num % 10 == 3 || (num / 10) % 10 == 3) num++;
            else {
                answer = num;
                num++;
                i++;
            }
        }
        return answer;
    }
}