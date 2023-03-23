class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int num = i; num <= j; num++) {
            sb.append(Integer.toString(num));
        }

        String[] str = sb.toString().split("");

        for(String s : str) {
            if(s.equals(Integer.toString(k))) answer ++;
        }
        return answer;
    }
}