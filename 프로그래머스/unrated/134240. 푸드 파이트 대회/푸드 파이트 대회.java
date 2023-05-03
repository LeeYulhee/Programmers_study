class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <  food.length; i++) {
            for(int j = 0; j < food[i]/2; j++) {
                sb.append(i);
            }
        }

        StringBuilder sbAfter = new StringBuilder(sb);
        sb.append(0);
        sb.append(sbAfter.reverse());
        return sb.toString();
    }
}