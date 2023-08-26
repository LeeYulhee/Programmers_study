import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 이름을 Key로, String Set을 Value로 갖는 Map 생성
        // => 해당 이름을 신고한 사람 Set을 저장됨
        // => Key에 해당하는 Set size가 k이상이면 해당 Set에 있는 사람들에 대한 answer 배열 요소를 + 1
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for(String s : id_list) {
            reportMap.put(s, new HashSet<>());
        }
        
        for(String s : report) {
            String[] division = s.split(" ");
            
            String reporter = division[0];
            String badman = division[1];
            reportMap.get(badman).add(reporter);
        }
        
        for(String s : id_list) {
            if(reportMap.get(s).size() >= k) {
                for(String reporter : reportMap.get(s)) {
                    int index = 0;
                    for(int i = 0; i < id_list.length; i++) {
                        if(id_list[i].equals(reporter)) {
                            index = i;
                            break;
                        }
                    }
                    
                    answer[index] += 1;
                }
            }
        }
        
        return answer;
    }
}