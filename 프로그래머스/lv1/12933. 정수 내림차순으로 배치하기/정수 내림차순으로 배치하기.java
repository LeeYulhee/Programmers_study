import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strArr = String.valueOf(n).split("");

        Arrays.sort(strArr, Collections.reverseOrder());

        return Long.parseLong(String.join("", strArr));
    }
}