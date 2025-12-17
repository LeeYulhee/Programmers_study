import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<int[]> leftQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Queue<int[]> rightQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            if (distance < S) {
                leftQueue.add(new int[]{S - distance, count});
            } else {
                rightQueue.add(new int[]{distance - S, count});
            }
        }

        int seats = K;
        int currentDistance = 0;

        while (!leftQueue.isEmpty()) {

            int[] current = leftQueue.poll();
            currentDistance = Math.max(currentDistance, current[0]);

            if (seats >= current[1]) {
                seats -= current[1];
            } else {
                current[1] -= seats;
                leftQueue.add(current);

                answer += 2 * currentDistance;
                seats = K;
                currentDistance = 0;
            }

            if (leftQueue.peek() == null) {
                answer += 2 * currentDistance;
                seats = K;
                currentDistance = 0;
            }
        }

        while (!rightQueue.isEmpty()) {

            int[] current = rightQueue.poll();
            currentDistance = Math.max(currentDistance, current[0]);

            if (seats >= current[1]) {
                seats -= current[1];
            } else {
                current[1] -= seats;
                rightQueue.add(current);

                answer += 2 * currentDistance;
                seats = K;
                currentDistance = 0;
            }

            if (rightQueue.peek() == null) {
                answer += 2 * currentDistance;
                seats = K;
                currentDistance = 0;
            }
        }

        System.out.println(answer);
    }
}