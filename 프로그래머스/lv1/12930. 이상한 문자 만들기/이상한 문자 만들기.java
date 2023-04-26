class Solution {
    public String solution(String s) {
        String[] str = s.split(" ", -1);

        StringBuilder sb = new StringBuilder();


        for(int index = 0; index < str.length; index++) {
            String temp = str[index];
            for(int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if(i % 2 == 0 && Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else if (i % 2 != 0 && Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            if(index == str.length - 1) break;
            sb.append(" ");
        }
        return sb.toString();
    }
}