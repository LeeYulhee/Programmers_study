class Solution {
    public int solution(int[] num_list) {
        StringBuilder evenNum = new StringBuilder();
        StringBuilder oddNum = new StringBuilder();
        
        for (int i : num_list) {
            (i % 2 == 0? oddNum : evenNum).append(i);
        }
        
        return Integer.parseInt(evenNum.toString()) + Integer.parseInt(oddNum.toString());
        
    }
}