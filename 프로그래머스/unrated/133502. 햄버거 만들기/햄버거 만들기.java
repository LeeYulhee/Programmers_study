import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stackHamburger = new Stack<>();
        
        Stack<Integer> hamburger = new Stack<>();
        hamburger.push(1);
        hamburger.push(2);
        hamburger.push(3);
        hamburger.push(1);
        
        for(int i : ingredient) {
            stackHamburger.push(i);
            if(stackHamburger.size() > 3 && stackHamburger.subList(stackHamburger.size() - 4, stackHamburger.size()).equals(hamburger)) {
                stackHamburger.pop();
                stackHamburger.pop();
                stackHamburger.pop();
                stackHamburger.pop();
                answer++;
            }
        }

        return answer;
    }
}