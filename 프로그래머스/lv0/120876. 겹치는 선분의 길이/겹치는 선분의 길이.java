import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[][] lines) {
        Set<Integer> count = new HashSet<Integer>();

        for(int first = lines[0][0]; first < lines[0][1]; first++) {
            for(int second = lines[1][0]; second < lines[1][1]; second++) {
                for(int third = lines[2][0]; third < lines[2][1]; third++) {
                    if(first == second) {
                        count.add(first);
                    } else if(second == third) {
                        count.add(second);
                    } else if(first == third) {
                        count.add(first);
                    }
                }
            }
        }

        int answer = count.size();
        
        return answer;
    }
}