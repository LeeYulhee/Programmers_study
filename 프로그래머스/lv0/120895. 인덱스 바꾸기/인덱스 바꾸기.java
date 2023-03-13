class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] arrStr = my_string.split("");
        StringBuilder sb = new StringBuilder();

        for(String str : arrStr){
            sb.append(str);
        }

        sb.replace(num1, num1+1, arrStr[num2]);
        sb.replace(num2, num2+1, arrStr[num1]);
        return sb.toString();
    }
}