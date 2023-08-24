import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // key가 이름인 Map과 등수인 Map 생성하고 값 대입
        Map<String, Integer> nameKeyMap = new HashMap<>();
        Map<Integer, String> rankKeyMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            nameKeyMap.put(players[i], i);
            rankKeyMap.put(i, players[i]);
        }
        
        // callings에 나오면 순서 변경
        for(String nowCalling : callings) {
            int beforeRanking = nameKeyMap.get(nowCalling);
            String beforePlayer = rankKeyMap.get(beforeRanking - 1);
            
            nameKeyMap.put(nowCalling, beforeRanking - 1);
            nameKeyMap.put(beforePlayer, beforeRanking);
            
            rankKeyMap.put(beforeRanking - 1, nowCalling);
            rankKeyMap.put(beforeRanking, beforePlayer);
        }
        
        // answer 배열 생성하고 Map의 값들 넣기
        String[] answer = new String[players.length];
        
        for(int i = 0; i < players.length; i++) {
            answer[i] = rankKeyMap.get(i);
        }
            
        return answer;
    }
}