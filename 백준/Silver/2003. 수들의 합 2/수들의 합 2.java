import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        while (left < N && right < N) {
            // 두 값을 보고 M보다 작으면 right++
            // 두 값을 보고 M보다 크면 left++
            // 해당 회차의 sum 값을 구해야 함
            // 만약 left == right가 되거나, sum == M이 되면 left++, right++

            int sum = 0;

            for (int i = left; i <= right; i++) {
                sum += arr[i];

                if (sum > M) break;
            }

            if (sum < M) {
                right++;
            } else if (sum > M) {
                left++;
            } else {
                answer++;
                left++;
                right++;
            }
        }

        System.out.println(answer);
    }
}