import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        // 1이상 99이하의 정수
        // N개의 카드 중 K개의 카드를 선택해 조합
        // => 만들 수 있는 정수의 개수(중복은 제외하는 걸로 보임)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N];
        used = new boolean[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        recursive(0, K, N, new StringBuilder());

        System.out.println(set.size());
    }

    static void recursive(int depth, int K, int N, StringBuilder sb) {
        if (depth == K) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;

            int length = sb.length();

            used[i] = true;
            sb.append(arr[i]);
            recursive(depth + 1, K, N, sb);

            used[i] = false;
            sb.setLength(length);
        }
    }
}