class Solution {
    public int solution(int[] num_list) {
        
        int addNum = 0;
        int multipleNum = 1;
        
        for (int i : num_list) {
            addNum += i;
            multipleNum *= i;
        }
        
        return multipleNum > addNum * addNum ? 0 : 1; 
    }
}