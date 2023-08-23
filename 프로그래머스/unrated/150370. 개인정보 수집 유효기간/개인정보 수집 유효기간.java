import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<Character, Integer> termsMap = new HashMap<>();
        
        List<Integer> tempAnswer = new LinkedList<>();
        
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8, 10));
        
        for(String s : terms) {
            termsMap.put(s.charAt(0), Integer.parseInt(s.substring(2, s.length())));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            
            int changeMonth = termsMap.get(privacies[i].charAt(11));
            
            int privacyYear = Integer.parseInt(privacies[i].substring(0, 4));
            int privacyMonth = Integer.parseInt(privacies[i].substring(5, 7));
            int privacyDay = Integer.parseInt(privacies[i].substring(8, 10));
            
            privacyMonth = privacyMonth + changeMonth;
            
            
            
            if(privacyDay == 1) {
                privacyDay = 28;
                privacyMonth--;
            } else {
                privacyDay = privacyDay - 1;
            }
            
            if(privacyMonth > 12) {
                if(privacyMonth % 12 == 0) {
                    privacyYear += privacyMonth / 12 - 1;
                    privacyMonth = 12;
                } else {
                    privacyYear += privacyMonth / 12;
                privacyMonth = privacyMonth % 12;
                }
            }
            
            if(todayYear > privacyYear) {
                tempAnswer.add(i + 1);
                continue;
            }
            if(todayYear == privacyYear && todayMonth > privacyMonth) {
                tempAnswer.add(i + 1);
                continue;
            }
            if(todayYear == privacyYear && todayMonth == privacyMonth && todayDay > privacyDay) {
                tempAnswer.add(i + 1);
                continue;
            }
        }
        
        int[] answer = new int[tempAnswer.size()];
        
        for(int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}