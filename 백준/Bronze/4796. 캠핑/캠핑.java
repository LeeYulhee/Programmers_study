import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 캠핑장은 연속하는 P일 중 L일동안만 사용 가능
        // V일 휴가를 시작
        // 캠핑장을 며칠동안 사용할 수 있을까

        // (V / P 값 * L) + (남은 휴가 일자 or L일 중 작은 값)
        // 0 0 0이 들어오면 종료

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            int fullDay = V / P * L;
            int modDay = Math.min(V - (V / P * P), L);

            System.out.printf("Case %d: %d\n", index, fullDay + modDay);

            index++;
        }
    }
}