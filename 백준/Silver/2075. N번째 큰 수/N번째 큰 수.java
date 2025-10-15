import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        // 메모리 초과 발생 => 힙 정렬을 최대 2,250,000개나 해서 그런듯..
        // 무조건 윗줄의 값이 아랫줄보다 작다고 했다는 걸 고려해야 할 것 같음
        // 내 생각엔 큐의 사이즈를 항상 N개로 정해놓고 제거 + 넣기를 반복해야 될 것 같기도 하고..
        for (int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < lines; j++) {
                int current = Integer.parseInt(st.nextToken());

                // 큐가 비어있지 않고, queue의 크기가 lines와 같으면
                if (!queue.isEmpty() && queue.size() >= lines) {
                    int queueNumber = queue.peek();
                    if (queueNumber < current) {
                        queue.poll();
                        queue.add(current);
                    }
                } else {
                    queue.add(current);
                }
            }
        }

        System.out.println(queue.peek());
    }
}