import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 트럭이 다리를 지나감
        // 트럭 순서는 바꿀 수 없음
        // 트럭 무게는 같지 않을 수 있음
        // 다리 위는 W대의 트럭만 동시에 올라갈 수 있음
        // 트럭들은 하나의 단위 길이만큼 이동 가능
        // 다리 위의 트럭 무게 합 <= 다리 최대 하중(L)
        // 다리 위에 전부 올라가지 못한 트럭은 배제
        // => 모든 트럭이 지나는 최소 시간을 구해야 함

        // 큐에 트럭을 넣는데,
        // 큐의 무게를 기준으로 poll() / push()

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int truckCount = Integer.parseInt(st.nextToken());
        int maxCount = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int currentWeight = 0;
        int totalTime = 0;
        int index = 0;

        int[] trucks = new int[truckCount];
        Queue<Integer> bridge = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < truckCount; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // 실제 무게가 남아있을 때만 계속 돈다
        while (index < truckCount || currentWeight > 0) {
            totalTime++;

            // 다리 길이 유지: 가득 차면 맨 앞이 한 칸 나감
            if (bridge.size() == maxCount) {
                currentWeight -= bridge.poll();
            }

            if (index < truckCount) {
                // 다음 트럭을 올릴 수 있으면 올리고, 아니면 0(빈칸)
                if (currentWeight + trucks[index] <= maxWeight) {
                    bridge.add(trucks[index]);
                    currentWeight += trucks[index];
                    index++;
                } else {
                    bridge.add(0);
                }
            } else {
                // 더 올릴 트럭은 없지만, 아직 다리 위에 트럭이 있으면 0을 넣어 밀어준다
                if (currentWeight > 0) {
                    bridge.add(0);
                }
                // currentWeight==0이면 조건식에서 루프 종료
            }
        }

        System.out.println(totalTime);
    }
}