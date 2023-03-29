class Solution {
    public int solution(int[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i : array)   {
            sb.append(i + "");
        }
        int answer = sb.toString().replaceAll("[^7]", "").length();
        return answer;
    }
}