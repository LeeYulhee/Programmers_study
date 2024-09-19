class Solution {
    public int solution(int[] num_list) {
        int oddIdxAdd      = 0;
        int multiIdxAdd    = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) multiIdxAdd += num_list[i];
            else            oddIdxAdd += num_list[i];
        }
        
        return Math.max(multiIdxAdd, oddIdxAdd);
    }
}