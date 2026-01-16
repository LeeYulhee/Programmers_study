import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer>[] connect = new ArrayList[N];
        int[] values = new int[N];
        int[] nodeDepth = new int[N];

        for (int i = 0; i < N; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());

            connect[node].add(nextNode);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int depth = nodeDepth[current];

            for (int i = 0; i < connect[current].size(); i++) {
                int nextNode = connect[current].get(i);

                if (nodeDepth[nextNode] == 0) nodeDepth[nextNode] = depth + 1;
                queue.add(nextNode);
            }
        }

        for (int i = 0; i < N; i++) {
            if (values[i] == K) {
                System.out.println(nodeDepth[i]);
                break;
            }
        }
    }
}
