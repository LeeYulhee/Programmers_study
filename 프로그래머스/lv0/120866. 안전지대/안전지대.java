class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;
        int[][] copy = new int[n][n];

        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    for(int x = i - 1; x <= i + 1; x++) {
                        for(int y = j - 1; y <= j + 1; y++) {
                            if(0 <= x && x < n && y < n && y >= 0)
                                copy[x][y] = 1;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < copy.length; i++) {
            for(int j = 0; j < copy[i].length; j++) {
                if(copy[i][j] == 0) answer ++;
            }
        }
        return answer;
    }
}