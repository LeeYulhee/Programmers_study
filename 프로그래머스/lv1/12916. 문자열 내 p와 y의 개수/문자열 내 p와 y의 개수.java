class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCounter = 0;
        int yCounter = 0;
        String[] str = s.toLowerCase().replaceAll("[^p|y]", "").split("");

        for(String temp : str) {
            if(temp.equals("p")) pCounter++;
            else if(temp.equals("y")) yCounter++;
        }

        if(pCounter != yCounter) answer = false;

        return answer;
    }
}