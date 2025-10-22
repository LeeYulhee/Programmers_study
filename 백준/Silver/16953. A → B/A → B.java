import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());
        int answer = 0;

        while (target >= start) {
            answer++;

            if (target == start) break;

            if (target % 10 == 1) {
                target /= 10;
            } else {
                // target이 2로 나눴을 때 정수인 경우만 나누기
                if (target / 2 * 2 != target) break;
                target /= 2;
                
            }
        }

        System.out.println(start == target ? answer : -1);
    }
}