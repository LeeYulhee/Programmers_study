class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");

        int answer = Integer.parseInt(str[0]);

        

        for (int i = 1; i < str.length -1; i += 2) {
            switch(str[i]){
                case "+": answer += Integer.parseInt(str[i + 1]); break;
                case "-" : answer -= Integer.parseInt(str[i + 1]); break;
            }
        }
        return answer;
    }
}