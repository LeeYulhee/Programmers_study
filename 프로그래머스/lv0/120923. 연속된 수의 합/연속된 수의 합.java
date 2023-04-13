class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int start = 0;

        int middle = ((total * 2) / num) % 2 == 0? ((total * 2) / num / 2) : ((total * 2) / num / 2) + 1;

        start = middle - (num / 2);

        for (int i = 0; i < num; i++) {
            answer[i] = start;
            start ++;
        }
        return answer;
    }
}