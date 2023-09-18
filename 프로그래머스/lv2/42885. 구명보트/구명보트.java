import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        int right = people.length - 1;
        int left = 0;
        int answer = 0;
        
        Arrays.sort(people);
        
        for(int i = 0; i < people.length; i++) {
            left = i;
            int rightCounter = 0;
            
            if(right < left) break;
            
            while(left < right) {
                
                if(people[left] + people[right] <= limit) {
                    answer++;
                    people[left] = 0;
                    people[right] = 0;
                    right--;
                    break;
                }
                right--;
            }
        }
        
        for(int i : people) {
            if (i != 0) answer++;
        }
        
        return answer;
    }
}