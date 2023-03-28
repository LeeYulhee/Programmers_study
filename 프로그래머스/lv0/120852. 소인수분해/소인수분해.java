import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public Set solution(int n) {
        int i = 2;
        
        Set<Integer> arr = new LinkedHashSet<Integer>();

        while(n > 1) {
            if (n % i == 0) {
                arr.add(i);
                n /= i;
            }
            else {
                i++;
            }
        }
        return arr;
    }
}