import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        // 오름차순 정렬 구현
        Arrays.sort(citations);
        
        // 가장 큰 경우의 수(배열의 길이)부터 1까지 순회(1이 안 되면 그냥 return 0)하며 배열의 요소가 해당 값과 같거나 크면 return
        for(int i = citations.length; i > 0; i--) {
            for(int j = 0; j <= citations.length - i; j++) {
                if(citations[j] >= i) return i;
            }
        }
        
        return 0;
    }
}