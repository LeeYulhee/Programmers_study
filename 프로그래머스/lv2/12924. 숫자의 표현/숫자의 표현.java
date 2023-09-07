class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            n = n - i;
            if(n % (i + 1) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}