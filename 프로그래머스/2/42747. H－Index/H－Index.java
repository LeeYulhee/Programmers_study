class Solution {
    public int solution(int[] citations) {
        
        int answer;
        
        // 버블 정렬로 오름차순 정렬 구현
        for(int i = 0; i < citations.length; i++) {
            for(int j = 1; j < citations.length - i; j++) {
                if(citations[j - 1] > citations[j]) {
                    int temp = citations[j - 1];
                    citations[j - 1] = citations[j];
                    citations[j] = temp;
                }
            }
        }
        
        // 가장 큰 경우의 수(배열의 길이)부터 1까지 순회(1이 안 되면 그냥 return 0)하며 배열의 요소가 해당 값과 같거나 크면 return
        for(int i = citations.length; i > 0; i--) {
            for(int j = 0; j <= citations.length - i; j++) {
                if(citations[j] >= i) return i;
            }
        }
        
        return 0;
    }
}