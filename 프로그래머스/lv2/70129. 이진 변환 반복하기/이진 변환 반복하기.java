class Solution {
    public int[] solution(String s) {
        
        int zeroCount = 0;
        int deleteZero = 0;
        
        while(!s.equals("1")) {
            
            StringBuilder sb = new StringBuilder();
            
            for(char c : s.toCharArray()) {
                if(c == '0') {
                    zeroCount++;
                } else {
                    sb.append("1");
                }
            }
            
            s = Integer.toBinaryString(sb.length());
                
            deleteZero++;
        }
        
        return new int[]{deleteZero, zeroCount};
    }
}