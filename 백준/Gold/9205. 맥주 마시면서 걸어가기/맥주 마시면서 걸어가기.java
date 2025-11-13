import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] points = new int[N][2];
            boolean[] visited = new boolean[N];
            int[] festival = new int[2];
            int[] start = new int[2];

            String answer = "sad";

            int index = 0;

            for (int j = 0; j < N + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                if (j == 0) {
                    start[0] = Integer.parseInt(st.nextToken());
                    start[1] = Integer.parseInt(st.nextToken());
                } else if (j == N + 2 - 1) {
                    festival[0] = Integer.parseInt(st.nextToken());
                    festival[1] = Integer.parseInt(st.nextToken());
                    break;
                } else {
                    points[index][0] = Integer.parseInt(st.nextToken());
                    points[index][1] = Integer.parseInt(st.nextToken());
                    index++;
                }
            }

            // 시작에서 도착지까지의 거리
            // 그 사이에 편의점이 있냐 => 1000 거리 이하에
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (Math.abs(current[0] - festival[0]) + Math.abs(current[1] - festival[1]) <= 1000) {
                    answer = "happy";
                    break;
                }

                for (int k = 0; k < N; k++) {
                    int[] market = points[k];

                    if (visited[k]) continue;

                    if (Math.abs(current[0] - market[0]) + Math.abs(current[1] - market[1]) <= 1000) {
                        queue.add(market);
                        visited[k] = true;
                    }


                }
            }

            System.out.println(answer);
        }
    }
}