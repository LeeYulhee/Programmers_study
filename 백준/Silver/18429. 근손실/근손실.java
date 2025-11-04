import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int answer = 0;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        // 현재 3대 500 => 하루에 중량이 K만큼 감소
        // N개의 키트를 사용해 N일 동안 하루도 500 미만이 되면 안 됨
        // 위를 충족하는 경우의 개수 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 500);

        System.out.println(answer);
    }

    // 사용하지 않은 도구
    // 500 이하가 되면 그 조합은 보지 않기
    static void recursive(int depth, int weight) {
        if (depth == N) {
            if (weight >= 500) answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;

            int current = weight - K + arr[i];

            if (current < 500) continue;

            used[i] = true;
            recursive(depth + 1, current);

            used[i] = false;
        }
    }
}