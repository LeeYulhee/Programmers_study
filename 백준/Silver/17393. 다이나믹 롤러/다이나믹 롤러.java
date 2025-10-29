import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 통로 : 1 * N
        // 타일 : 1 * 1
        // 첫 번째 배열의 값이
        // 두 번째 배열의 어디에 있는지(제일 큰 같거나 작은 값)
        // 그 위치를 배열에 담아 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] inks = new long[N];
        long[] sticky = new long[N];
        long[] answer = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inks[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sticky[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            long target = inks[i];

            int start = i + 1;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (target < sticky[mid]) {
                    end = mid - 1;
                }
                else {
                    // 같지 않을 때는 가장 많은 칸으로 계속 갱신해줘야 함
                    answer[i] = mid - i;
                    start = mid + 1;
                }
            }
        }

        // System.out.println(Arrays.toString(answer));

        StringBuilder sb = new StringBuilder();

        for (long number : answer) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}