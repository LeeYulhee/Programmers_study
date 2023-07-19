import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> numsList = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    numsList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for(int i : numsList) {
            for(int j = 2; j <= Math.sqrt(i); j++) {

                if(i % j == 0) {
                    break;
                }

                if(j == (int)Math.sqrt(i)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}