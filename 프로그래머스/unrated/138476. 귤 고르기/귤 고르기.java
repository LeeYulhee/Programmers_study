import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int total = 0;
        int tangerineLength = tangerine.length;
        
        Arrays.sort(tangerine);
        
        Integer[] typeIndex = new Integer[tangerine[tangerineLength - 1] + 1];
        
        Arrays.fill(typeIndex, 0);
        
        for(int i : tangerine) {
            typeIndex[i]++;
        }
        
        Arrays.sort(typeIndex, Collections.reverseOrder());
        
        for(int i = 0; i < typeIndex.length; i++) {
            total += typeIndex[i];
            if(total >= k) {
                return i + 1;
            }
        }
        
        return 0;
    }
}