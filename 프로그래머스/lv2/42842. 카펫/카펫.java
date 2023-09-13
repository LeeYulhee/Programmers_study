class Solution {
    public int[] solution(int brown, int yellow) {
        
        int x = 0;
        int y = 0;
        int area = brown + yellow;
        
        for(int i = 1; i <= area / 2; i++) {
            if(area % i == 0) {
                x = i >= area / i ? i : area / i;
                y = i < area / i ? i : area / i;
            }
            
            if((x - 2) * (y - 2) == yellow) break;
        }
        
        return new int[]{x, y};
    }
}