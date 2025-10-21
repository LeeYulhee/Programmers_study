import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // N : 동전 종류 수
        // K : 도달해야 하는 금액
        // 최소 개수로 K에 도달 => 총 몇 개가 필요한지 출력

        // 동전은 오름차순으로 들어옴 => K보다 큰 금액이 나오면 볼 필요 없음
        // 금액 단위를 배열로 담은 다음에 역순으로 보면서 크면 넘기고, 안 크면 그 수부터 나눠서 갖고 있기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        int index = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
            if (array[i] <= K) index = i;
        }

        while (K > 0) {
            answer += K / array[index];
            K %= array[index];
            index--;
        }

        System.out.println(answer);
    }
}