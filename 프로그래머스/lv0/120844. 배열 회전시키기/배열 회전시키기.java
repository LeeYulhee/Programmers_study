import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : numbers){
            list.add(i);
        }

        if(direction.equals("right")){
            list.add(0, list.get(list.size()-1));
            list.remove(list.size()-1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        
        return answer;
    }
}