import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        int[][] numberPosition = new int[12][2];
        
        
        for(int i = 0; i < 10; i++) {
            if (i == 0) {
                numberPosition[0] = new int[]{3, 1};
                numberPosition[10] = new int[]{3, 0};
                numberPosition[11] = new int[]{3, 2};
            } else {
                numberPosition[i] = new int[]{(i - 1) / 3, (i - 1) % 3};
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int leftThumb = 10;
        int rightThumb = 11;
        
        for(int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                sb.append("L");
                leftThumb = i;
            } else if (i == 3 || i == 6 || i == 9) {
                sb.append("R");
                rightThumb = i;
            } else {
                int leftDistance = Math.abs(numberPosition[i][0] - numberPosition[leftThumb][0]) + Math.abs(numberPosition[i][1] - numberPosition[leftThumb][1]);
                int rightDistance = Math.abs(numberPosition[i][0] - numberPosition[rightThumb][0]) + Math.abs(numberPosition[i][1] - numberPosition[rightThumb][1]);
                
                if(leftDistance < rightDistance) {
                    sb.append("L");
                    leftThumb = i;
                } else if (rightDistance < leftDistance) {
                    sb.append("R");
                    rightThumb = i;
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        rightThumb = i;
                    } else {
                        sb.append("L");
                        leftThumb = i;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}