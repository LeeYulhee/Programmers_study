class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int winNumber = 0;
        int zeroCount = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCount++;
            } else {
                for (int j : win_nums) {
                    if(lottos[i] == j) {
                        winNumber++;
                    }
                }
            }
        }

        int possibleLotto = winNumber + zeroCount;


        for (int i = 0; i < answer.length; i++) {
            switch(possibleLotto) {
                case 0 : answer[i] = 6; break;
                case 1 : answer[i] = 6; break;
                case 2 : answer[i] = 5; break;
                case 3 : answer[i] = 4; break;
                case 4 : answer[i] = 3; break;
                case 5 : answer[i] = 2; break;
                case 6 : answer[i] = 1; break;
            }

            possibleLotto = winNumber;
        }
        return answer;
    }
}