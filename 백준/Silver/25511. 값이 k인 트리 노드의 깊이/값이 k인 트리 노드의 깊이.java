import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 부모 자식이 주어짐
        // 해당 노드의 'value'가 따로 주어짐
        // k == value 일 때, depth를 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer>[] connect = new ArrayList[N];
        int[] parents = new int[N];
        int[] values = new int[N];
        int[] nodeDepth = new int[N];

        for (int i = 0; i < N; i++) {
            connect[i] = new ArrayList<>();
        }

        Arrays.fill(parents, -1);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());

            connect[node].add(nextNode);
            parents[nextNode] = node;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int root = 0;

        for (int i = 0; i < N; i++) {
            if (parents[i] == -1) root = i;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();
//            int parent = parents[current];
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