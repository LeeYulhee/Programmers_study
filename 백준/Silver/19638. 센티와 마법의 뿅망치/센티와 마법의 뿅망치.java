import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < T; i++) {
            if (!queue.isEmpty() && queue.peek() >= H) {
                queue.add(Math.max(queue.poll() / 2, 1));
                count++;
            } else {
                break;
            }
        }

        if (queue.peek() < H) {
            System.out.println("YES\n" + count);
        } else {
            System.out.println("NO\n" + queue.peek());
        }
    }
}