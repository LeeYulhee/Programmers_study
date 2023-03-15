class Solution {
    public String solution(int age) {
        String[] str = String.valueOf(age).split("");

        for(int i = 0; i < str.length; i++){
            switch(str[i]){
                case "0": str[i] = "a"; break;
                case "1": str[i] = "b"; break;
                case "2": str[i] = "c"; break;
                case "3": str[i] = "d"; break;
                case "4": str[i] = "e"; break;
                case "5": str[i] = "f"; break;
                case "6": str[i] = "g"; break;
                case "7": str[i] = "h"; break;
                case "8": str[i] = "i"; break;
                case "9": str[i] = "j"; break;
            }
        }

        String answer = String.join("", str);
        return answer;
    }
}