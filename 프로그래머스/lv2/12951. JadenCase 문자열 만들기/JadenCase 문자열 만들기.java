class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] splitS = s.split("");
        
        int index = 0;
        
        for(String str : splitS) {
            if(str.equals(" ")) {
                sb.append(" ");
                index = 0;
                continue;
            }
            str = index == 0 ? str.toUpperCase() : str.toLowerCase();
            sb.append(str);
            index++;
        }
        
        return sb.toString();
    }
}