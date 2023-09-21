class Solution {
    public int solution(int n, int a, int b) {
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        int round = 0;
        
        while(true) {

            if(max - min ==  1 && (min - 1) / 2 == (max - 1) / 2) {
                return round + 1;
            }
            
            min = min % 2 == 1 ? (min + 1) / 2 : min / 2;
            max = max % 2 == 1 ? (max + 1) / 2 : max / 2;
            
            round++;
        }
    }
}