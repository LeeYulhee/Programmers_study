class Solution {
    public String solution(String polynomial) {
        int numCounter = 0;
        int xCounter = 0;
        String answer = "0";

        String[] str = polynomial.split(" ");

        for(String s : str) {
            if (s.equals("x")) {
                xCounter ++;
            } else if (s.contains("x")) {
                xCounter += Integer.parseInt(s.replaceAll("[x]", ""));
            } else if (!s.equals("+")){
                numCounter += Integer.parseInt(s);
            }
        }

        
        if (xCounter == 1) {
            if (numCounter != 0)
            answer = "x" + " + " + numCounter;
            else if (numCounter == 0) {
                answer = "x";
            }
        }
        else if (xCounter == 0) answer = numCounter+"";
        else if (xCounter != 0 && numCounter == 0) answer = xCounter + "x";
        else if (xCounter != 0 && numCounter != 0) answer = (xCounter + "x" + " + " + numCounter);
        
        return answer;
    }
}