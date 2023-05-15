import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for(int[] arr : sizes) {
            Arrays.sort(arr);
            if(arr[0] > width) width = arr[0];
            if(arr[1] > height) height = arr[1];
        }
        return width * height;
    }
}