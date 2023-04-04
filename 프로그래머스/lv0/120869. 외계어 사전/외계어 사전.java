class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;


        for(String dicS : dic) {

            boolean isRight = true;
            for(String spellS : spell) {
                if(dicS.indexOf(spellS) == -1) {
                    isRight = false;
                    break;
                }
            }

            if(isRight) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}