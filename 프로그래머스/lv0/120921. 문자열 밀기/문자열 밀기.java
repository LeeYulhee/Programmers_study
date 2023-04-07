class Solution {
    public int solution(String A, String B) {
        String move = new String(A);
                                 
        int count = 0;

        if (A.equals(B)) return 0;

        for(int i = 1; i < A.length(); i++) {
            String str = "";
            str = move.charAt(A.length()-1) + "";
            str += move.substring(0, A.length()-1);
            count += 1;
            if(str.equals(B)) {
                return count;
            }
            move = str;
        }
                                 
        return -1;
    }
}