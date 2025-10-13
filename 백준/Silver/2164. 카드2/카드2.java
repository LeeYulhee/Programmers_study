import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardCount = Integer.parseInt(br.readLine());
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= cardCount; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int trashCard = queue.poll();
            if (queue.isEmpty()) {
                answer = trashCard;
                break;
            }
            if (queue.peek() != null) {
                int number = queue.poll();
                queue.add(number);
            }
            if (queue.size() == 1) {
                answer = queue.poll();
                break;
            }
        }

        System.out.println(answer);
    }
}