class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        if(dots[0][0] - dots[1][0] == 0) {
            if(slope(dots[0][0], dots[2][0], dots[0][1], dots[2][1]) == slope(dots[1][0], dots[3][0], dots[1][1], dots[3][1])) answer = 1;
        }
        else if (slope(dots[0][0], dots[1][0], dots[0][1], dots[1][1]) == slope(dots[2][0], dots[3][0], dots[2][1], dots[3][1])) answer = 1;
        
        return answer;
    }
    
    public static double slope (int a0, int a1, int b0, int b1) {
        int x = Math.max(a0, a1) - Math.min(a0, a1);
        int y = Math.max(b0, b1) - Math.min(b0, b1);
        return (double) y / x;
    }
}