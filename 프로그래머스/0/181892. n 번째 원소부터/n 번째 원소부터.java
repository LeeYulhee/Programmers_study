class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int index = n - 1;
        
        int[] answer = new int[num_list.length - index];
        
        for(int i = 0; index < num_list.length; i++) {
            answer[i] = num_list[index];
            index += 1;
        }
        
        return answer;
    }
}