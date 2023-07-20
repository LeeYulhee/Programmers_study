class Solution {
    public int solution(int n) {
        
        int answer = 0;

        boolean[] isPrime = new boolean[n + 1];

        for(int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(long j = i * i; j <= n; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        for(boolean b : isPrime) {
            if(b) answer++;
        }
        return answer;
    }
}