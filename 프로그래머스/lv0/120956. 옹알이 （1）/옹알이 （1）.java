class Solution {
    public int solution(String[] babbling) {
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(String s : babbling) {
            for(String can : canSpeak) {
                s = s.replace(can, " ");
                if(s.trim().equals("")) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}