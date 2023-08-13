import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int answer = 0;
        
        Stack<Integer> pickStack = new Stack<>();
        
        for (int i : moves) {
            
            int lineIndex = i - 1;
            
            for (int j = 0; j < board.length; j++) {
                int dollType = board[j][lineIndex];
                if(dollType != 0) {
                    if(!pickStack.isEmpty() && pickStack.peek() == dollType) {
                        pickStack.pop();
                        answer += 2;
                        board[j][lineIndex] = 0;
                        break;
                    } else {
                        pickStack.push(dollType);
                        board[j][lineIndex] = 0;
                        break;
                    }
                }
                
            }
        }

        return answer;
    }
}