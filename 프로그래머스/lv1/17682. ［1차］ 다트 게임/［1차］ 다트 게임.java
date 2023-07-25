class Solution {
    public int solution(String dartResult) {
        String[] strArray = dartResult.split("");

        int answer = 0;


        int beforeNumber = 0;
        int nowNumber = 0;

        for(int i = 0; i < strArray.length; ) {
            if(strArray[i].matches("[0-9]+")) {

                answer += nowNumber;
                beforeNumber = nowNumber;

                if(strArray[i].equals("1") && strArray[i+1].equals("0")) {
                    nowNumber = 10;
                    i ++;
                } else {
                    nowNumber = Integer.parseInt(strArray[i]);
                }
            } else {
                switch(strArray[i]) {
                    case "S": break;
                    case "D": nowNumber = (int)Math.pow(nowNumber, 2); break;
                    case "T": nowNumber = (int)Math.pow(nowNumber, 3); break;
                    case "*": nowNumber = nowNumber * 2; answer -= beforeNumber; beforeNumber = beforeNumber * 2; answer += beforeNumber; break;
                    case "#": nowNumber = nowNumber * -1; break;
                }
            }

            if(i == strArray.length - 1) {
                answer += nowNumber;
            }

            i++;
        }
        return answer;
    }
}