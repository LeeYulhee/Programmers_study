class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            String a = Integer.toString(arr1[i], 2);
            String b = Integer.toString(arr2[i], 2);
            if(a.length() < n) {
                a = "0".repeat(n - a.length()) + a;
            }
            if (b.length() < n) {
                b = "0".repeat(n - b.length()) + b;
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(a.charAt(j) == '1' || b.charAt(j) == '1') {
                    sb.append("#");
                } else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}