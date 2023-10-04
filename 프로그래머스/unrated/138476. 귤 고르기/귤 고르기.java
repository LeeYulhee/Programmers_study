import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int total = 0;
        int answer = 0;
        int tangerineLength = tangerine.length;
        
        Arrays.sort(tangerine);
        
        int[] typeIndex = new int[tangerine[tangerineLength - 1] + 1];
        
        for(int i : tangerine) {
            typeIndex[i]++;
        }
        
        Arrays.sort(typeIndex);
        
        for(int i = typeIndex.length - 1; i >= 0; i--) {
            answer++;
            total += typeIndex[i];
            if(total >= k) {
                return answer;
            }
        }
        
        return answer;
    }
}