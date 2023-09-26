class Solution {
    public long solution(int n) {
        
        long answer = 1;
        long beforeNum = 0;
        
        for(int i = 2; i <= n + 1; i++) {
            
            long temp = answer;
            answer = (answer + beforeNum) % 1234567;
            beforeNum = temp;
            
            
        }
        
        return answer;
    }
}