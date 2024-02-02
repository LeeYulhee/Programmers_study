class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String targetColor = board[h][w];
        String color = "";
        int[] x = {0, 1, -1, 0};
        int[] y = {1, 0, 0, -1};
        int boardH = board.length - 1;
        int boardY = board[0].length - 1;
        
        for(int i = 0; i < 4; i++) {
            int nowH = h + x[i];
            int nowY = w + y[i];

            if ( nowH > boardH || nowY > boardY || nowH < 0 || nowY < 0 ) {
                continue;
            }
            
            color = board[h + x[i]][w + y[i]];

            if(targetColor.equals(color)) {
                answer++;
            }
        }

        return answer;
    }
}