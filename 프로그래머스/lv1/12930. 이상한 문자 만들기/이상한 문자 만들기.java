class Solution {
    public String solution(String s) {
        String[] str = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();


        for(int index = 0; index < str.length; index++) {
            String temp = str[index];
            for(int i = 0; i < temp.length(); i++) {
                if(i % 2 == 0 && (temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z')) {
                    sb.append(String.valueOf((char) (temp.charAt(i) - 32)));
                } else if (i % 2 != 0 && (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z')) {
                    sb.append(String.valueOf((char) (temp.charAt(i) + 32)));
                } else {
                    sb.append(String.valueOf(temp.charAt(i)));
                }
            }
            
            if(index == str.length - 1) break;
            sb.append(" ");
        }
        return sb.toString();
    }
}