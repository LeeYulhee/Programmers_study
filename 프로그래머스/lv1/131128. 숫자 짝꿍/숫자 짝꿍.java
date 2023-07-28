import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for(int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0'] ++;
        }

        for(int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0'] ++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < xCount.length; i++) {
            if(xCount[i] >= yCount[i]) {
                sb.append(String.valueOf(i).repeat(yCount[i]));
            } else {
                sb.append(String.valueOf(i).repeat(xCount[i]));
            }
        }

        if(sb.toString().matches("^0+$")) {
            return "0";
        }
        
        if(sb.length() == 0) {
            return "-1";
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}