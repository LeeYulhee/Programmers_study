class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        for (String s : dic) {
            String tmp = s;
            for(int i = 0; i < spell.length; i++) {
                if (s.length() == spell.length) {
                    tmp = tmp.replaceFirst(spell[i], "");
                    System.out.println(tmp);
                }
            }
            if (tmp.equals("")) {
                answer = 1;
                break;
            } else answer = 2;
        }
        return answer;
    }
}