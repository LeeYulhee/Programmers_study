import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] isLived = new boolean[N + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int target = Integer.parseInt(br.readLine());
            int current = target;
            int min = Integer.MAX_VALUE;

            while (current >= 1) {
                if (isLived[current]) min = Math.min(current, min);
                if (current == 1) break;

                current /= 2;
            }

            if (min == Integer.MAX_VALUE) {
                isLived[target] = true;
                sb.append(0).append("\n");
            }
            else {
                sb.append(min).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}