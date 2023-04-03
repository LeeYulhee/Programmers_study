import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger a = factorial(balls);
        BigInteger b = factorial(share);
        BigInteger c = factorial(balls - share);

        int answer = (a.divide(b.multiply(c))).intValue();
        return answer;
    }
    
    static public BigInteger factorial(int num) {
        BigInteger bigNum1 = BigInteger.ONE; 
        for(int i = num; i > 0; i --) {
            bigNum1 = bigNum1.multiply(BigInteger.valueOf(i));
        }
        return bigNum1;
    }
}