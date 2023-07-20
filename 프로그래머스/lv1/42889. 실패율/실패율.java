import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Arrays.sort(stages);

        int clearPersonLength = 0;

        if (N > stages[stages.length - 1]) {
            clearPersonLength = N + 1;
        } else {
            clearPersonLength = stages[stages.length - 1] + 1;
        }

        int[] clearPerson = new int[clearPersonLength];

        for(int i : stages) {
            clearPerson[i]++;
        }

        Map<Integer, Double> failureRate = new HashMap<>();

        int stagePerson = stages.length;

        for(int i = 1; i < clearPerson.length; i++) {

            if(stagePerson == 0) {
                failureRate.put(i, 0d);
            } else {
                failureRate.put(i, (double) clearPerson[i] / stagePerson);
            }
            stagePerson -= clearPerson[i];
        }

        List<Integer> keySet = new ArrayList<>(failureRate.keySet());

        keySet.sort((o1, o2) -> failureRate.get(o2).compareTo(failureRate.get(o1)));

        int index = 0;

        for(int i : keySet) {
            if(1 <= i && i <= N) {
                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
}