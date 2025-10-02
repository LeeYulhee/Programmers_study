import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // A 이상 B 이하의 수 중 4와 7로만 이루어진 수의 개수
        // 문자열 변환해서 치환 후 계산 => 메모리 초과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (; start <= end; start++) {
            recursive(start, true);
        }

        System.out.println(answer);
    }

    // 숫자를 넣으면 1의 자리씩 보는 게 필요할 것 같은데 그건 % 10으로 보면 될 것 같고
    // 이거를 이 숫자의 몫이 0이 될 때까지 반복해야 될 것 같다
    static void recursive(int number, boolean isTarget) {
        if (number == 0) {
            if (isTarget) {
                answer++;
            }
            return;
        }

        // isTarget이 한 번이라도 false면 그건 그대로 false여야 됨
        if (!isTarget) return;
        
        isTarget = number % 10 == 7 || number % 10 == 4;
        recursive(number / 10, isTarget);
    }
}