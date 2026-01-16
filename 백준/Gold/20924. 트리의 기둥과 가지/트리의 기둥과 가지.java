import java.io.*;
import java.util.*;

public class Main {

    static int maxHeight = 0;

    static List<int[]>[] connect;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        connect = new ArrayList[N + 1];
        parents = new int[N + 1];
        
        Arrays.fill(parents, -1);

        for (int i = 1; i <= N; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            connect[node1].add(new int[]{node2, weight});
            connect[node2].add(new int[]{node1, weight});
        }

        int pillar = 0;
        int gigaNode = 0;
        boolean isPillar = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        parents[R] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int sonCount = current == R ? connect[current].size() : connect[current].size() - 1;
            
            if (sonCount >= 2) {
                isPillar = false;

                if (gigaNode == 0) gigaNode = current;
            }

            // 자신의 자식 노드들의 부모를 자기 자신으로 입력(부모 노드 입력이 안 되어 있는 경우만)
            // 자신의 부모 노드가 아니면(=자식이면) queue에 넣기(부모를 탐색해야 하니까)
            // 만약 기둥이면 pillar에 가중치 더하기
            for (int[] arr : connect[current]) {
                int sonNode = arr[0];

                if (parents[sonNode] == -1) {
                    parents[sonNode] = current;
                }

                if (sonNode != parents[current]) {
                    queue.add(sonNode);

                    if (isPillar) pillar += arr[1];
                }
            }
        }

        // 제일 긴 가지 구하기(기가 노드부터)
        if (gigaNode != 0) findLongBranch(gigaNode, 0);

        System.out.println(pillar + " " + maxHeight);
    }

    static void findLongBranch(int node, int height) {
        if (connect[node].size() == 1) {
            maxHeight = Math.max(height, maxHeight);
            return;
        }

        // 부모 노드가 아니면 height에 더하면서 탐색
        List<int[]> sonNodes = connect[node];

        for (int[] arr : sonNodes) {
            int sonNode = arr[0];
            int sonHeight = arr[1];

            if (sonNode != parents[node]) findLongBranch(sonNode, height + sonHeight);
        }
    }
}