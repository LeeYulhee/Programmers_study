import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        Map<String, Integer> wantIndex = new HashMap<>();
        
        int[] count = Arrays.copyOf(number, number.length);
        
        for(int i = 0; i < want.length; i++) {
            wantIndex.put(want[i], i);
        }
        
        for(int i = 0; i <= discount.length - 10; i++) {
            
            boolean possible = true;
            
            for(int j = i; j < i + 10; j++) {
                Integer index = wantIndex.get(discount[j]);
                
                if(index == null || count[index] == 0) {
                    possible = false;
                    break;
                }
                count[index]--;
            }
            
            for(int k : count) {
                if(k != 0) possible = false;
            }
            
            if(possible) answer++;
            
            count = Arrays.copyOf(number, number.length);
        }
        
        return answer;
    }
}