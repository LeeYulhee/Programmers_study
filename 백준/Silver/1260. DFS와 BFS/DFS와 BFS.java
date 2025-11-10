import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;

    // static List<Queue<Integer>> list;
    static List<List<Integer>> list;
    static boolean[] isDfsUsed;
    static boolean[] isBfsUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isDfsUsed = new boolean[N + 1];
        isBfsUsed = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            // list.add(new PriorityQueue<>());
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // Queue<Integer> node1List = list.get(node1);
            List<Integer> node1List = list.get(node1);
            node1List.add(node2);

            // Queue<Integer> node2List = list.get(node2);
            List<Integer> node2List = list.get(node2);
            node2List.add(node1);
        }

        for (List<Integer> curr : list) {
            Collections.sort(curr);
        }

        StringBuilder dfsSb = new StringBuilder();
        StringBuilder bfsSb = new StringBuilder();

        dfs(V, dfsSb);
        bfs(V, bfsSb);

        System.out.println(dfsSb.toString());
        System.out.println(bfsSb.toString());
    }

    // DFS는 한 레벨을 확인하고 다음 레벨로
    // 종료 조건 : 깊이가 모든 노드만큼 되면 멈추기?
    static void dfs(int node, StringBuilder sb) {

        // 시작 노드의 배열을 받아오기
        // 그 배열의 노드에 들어가기
        // if (depth == N) return;

        // Queue<Integer> nodeList = list.get(node);
        List<Integer> nodeList = list.get(node);

        isDfsUsed[node] = true;
        sb.append(node).append(" ");

        for (int nextNode : nodeList) {
            if (isDfsUsed[nextNode]) continue;

            dfs(nextNode, sb);
        }
    }

    // BFS는 같은 레벨을 확인하고 다음 레벨로
    static void bfs(int node, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        isBfsUsed[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");

            for (int i : list.get(curr)) {
                if (!isBfsUsed[i]) {
                    isBfsUsed[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}