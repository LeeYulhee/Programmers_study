import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int per = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int current = start + (per * j);
                if (current - T >= 0) {
                    answer = Math.min(answer, current - T);
                    break;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}