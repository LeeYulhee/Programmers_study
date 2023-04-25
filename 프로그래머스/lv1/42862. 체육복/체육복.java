import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<Integer>();

        for(int l : lost) {
            lostList.add(l);
        }

        for(int r : reserve) {
            reserveList.add(r);
        }

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(reserveList.contains(lost[i]) && lostList.contains(lost[i])) {
                    reserveList.remove(reserveList.indexOf(lost[i]));
                    lostList.remove(lostList.indexOf(lost[i]));
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            if (reserveList.contains(lost[i] - 1) && lostList.indexOf(lost[i]) != -1) {
                reserveList.remove(reserveList.indexOf(lost[i] - 1));
                lostList.remove(lostList.indexOf(lost[i]));
            } else if (reserveList.contains(lost[i] + 1) && lostList.indexOf(lost[i]) != -1) {
                reserveList.remove(reserveList.indexOf(lost[i] + 1));
                lostList.remove(lostList.indexOf(lost[i]));
            }
        }
        return n - lostList.size();
    }
}