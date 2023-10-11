class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1];
        int index = 0;
        
        for(long i = left; i <= right; i++) {
            int line = (int)(i / n);
            int column = (int)(i % n);
            answer[index] = Math.max(line, column) + 1;
            index++;
        }
        
        return answer;
    }
}