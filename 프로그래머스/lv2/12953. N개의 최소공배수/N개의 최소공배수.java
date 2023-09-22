class Solution {
    public int solution(int[] arr) {
        
        // 첫 번째 수와 두 번째 수의 최소공배수를 구함
        // 구한 최소공배수와 세 번째 수의 최소공배수를 구함
        
        int totalGcd = 0;
        int lcm = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            
            // 전에 계산한 값(최소공배수)과 현재 값의 최대공약수 구하기
            totalGcd = gcd(lcm, arr[i]);
            // 위에 인수로 들어간 두 수의 최소공배수를 구함
            lcm = lcm * arr[i] / totalGcd;
        }

        return lcm;
    }
    
    public int gcd(int a, int b) {
        
        if(b == 0) return a;
        
        int temp = a;
        a = b;
        b = temp % b;

        return gcd(a, b);
    }
}