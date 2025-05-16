import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node other) {
            return this.weight - other.weight; // 거리 기준으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(br.readLine()); // 시작점

        List<Node>[] links = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            links[i] = new ArrayList<>();
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, (int)1e9); // 1000000000 = INF

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            links[A].add(new Node(B, C));
        }

        // 다익스트라 시작
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.vertex;
            int cost = current.weight;

            // 이미 더 짧은 거리로 처리된 경우는 무시
            if (dist[now] < cost) continue;

            for (Node next : links[now]) {
                int newCost = dist[now] + next.weight;
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.offer(new Node(next.vertex, newCost));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (dist[i] == (int)1e9) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
