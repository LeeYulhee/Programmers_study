class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;

        for (String s : quiz) {
            String[] calc = s.split(" ");
            int tmp = 0;

            switch(calc[1]) {
                case "+" : tmp = Integer.parseInt(calc[0]) + Integer.parseInt(calc[2]); break;
                case "-" : tmp = Integer.parseInt(calc[0]) - Integer.parseInt(calc[2]); break;
            }

            if (tmp == Integer.parseInt(calc[4])) answer[i] = "O";
            else answer [i] = "X";
            
            i++;
        }
        return answer;
    }
}