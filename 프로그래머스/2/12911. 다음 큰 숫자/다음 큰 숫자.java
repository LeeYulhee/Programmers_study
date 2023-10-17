class Solution {
    public int solution(int n) {
        
        int oneCounter = Integer.toBinaryString(n).replace("0", "").length();
        int findNum = n + 1;

        while(true) {
            int check = Integer.toBinaryString(findNum).replace("0", "").length();
            if(check == oneCounter) return findNum;
            findNum++;
        }
    }
}