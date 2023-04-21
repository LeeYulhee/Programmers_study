class Solution {
    public long solution(long n) {
        return (long)Math.sqrt(n) == Math.sqrt(n) ? (long)Math.pow(Math.sqrt(n)+1, 2) : -1;
    }
}