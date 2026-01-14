import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.addLast(num);
            set.add(num);
        }

        int[] parents = new int[set.size()];
        Arrays.fill(parents, -2);

        int currentParent = -1;

        while (!deque.isEmpty()) {
            int node = deque.pollFirst();

            if (parents[node] == -2) {
                parents[node] = currentParent;
            }

            currentParent = node;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : parents) {
            sb.append(i).append(" ");
        }

        System.out.println(set.size());
        System.out.println(sb.toString());
    }
}