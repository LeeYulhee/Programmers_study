import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        isUsed = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(1));
    }

    static int bfs(int index) {
        // 각 위치에서 갈 수 있는 만큼은
        // 1 ~ curr까지
        // 전부 큐에 넣고 그 뒤만큼 탐색
        int step = -1;

        Queue<int[]> queue = new LinkedList<>();
        isUsed[index] = true;
        queue.add(new int[]{index, 0});

        while (!queue.isEmpty()) {
            int[] currArr = queue.poll();
            int currIndex = currArr[0];
            int currStep = currArr[1];
            int curr = arr[currIndex];

            if (currIndex == N) {
                step = currStep;
                break;
            }

            for (int i = 1; i <= curr; i++) {
                if (currIndex + i > N) break;
                if (isUsed[currIndex + i]) continue;

                isUsed[currIndex + i] = true;
                queue.add(new int[]{currIndex + i, currStep + 1});
            }
        }

        return step;
    }
}