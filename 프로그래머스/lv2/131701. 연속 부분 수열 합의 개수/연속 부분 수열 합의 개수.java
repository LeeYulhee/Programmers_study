import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        int elementsLength = elements.length;
        
        for(int i = 0; i < elementsLength; i++) {
            
            int chapter = 0;
            
            for(int j = 0; j < elementsLength; j++) {
                chapter += elements[(i + j) % elementsLength];
                set.add(chapter);
            }
        }
        
        return set.size();
    }
}