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
        Queue<Integer> queue = new PriorityQueue<>(lines);

        for (int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < lines; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (queue.size() < lines) queue.add(current);
                else if (current > queue.peek()) {
                    queue.poll();
                    queue.add(current);
                }
            }
        }

        System.out.println(queue.peek());
    }
}