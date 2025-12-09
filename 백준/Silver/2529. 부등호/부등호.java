import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isUsed = new boolean[10];
    static String[] inputs;
    static String max = String.valueOf(Long.MIN_VALUE);
    static String min = String.valueOf(Long.MAX_VALUE);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inputs = new String[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            inputs[i] = st.nextToken();
        }
        
        // 부등호[]를 0 제외하고 1부터 N 인덱스에 넣어서 사용
        // 숫자[] 혹은 숫자 StringBuilder는 0을 예외 처리하고(그냥 사용하는 걸로) 1부터 N 인덱스까지 숫자 채우기
        // => 둘 다 N + 1로 생성해서 사용해야 함

        // 0부커 9까지의 숫자를 다 살펴보면서
        // 1. 사용하지 않은 숫자를 넣어서 부등호에 맞는 상황인지 확인한다
        // 2 - 1. 맞는 경우 재귀 호출(step + 1)
        // 2 - 1 - 1. 재귀 호출 후 해당 값을 미사용처리 해줘야 사용 안 한 케이스도 보려나?
        // 2 - 2. 틀린 경우
        // 2 - 2 - 1. > 인데 현재 값이 더 큰 경우 : 다음 숫자들을 볼 필요가 있나?
        // 3. max와 min 비교해서 값 저장하기

        recursive(0, new StringBuilder());

        System.out.println(max + "\n" + min);
    }

    static void recursive(int step, StringBuilder sb) {
        // 내가 도달해야 하는 step : N + 1보다 커질 때 멈춰야 할 것 같은데
        if (step == N + 1) {
            max = Long.parseLong(sb.toString()) > Long.parseLong(max) ? sb.toString() : max;
            min = Long.parseLong(sb.toString()) < Long.parseLong(min) ? sb.toString() : min;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isUsed[i]) continue;

            if (step == 0) {
                sb.append(i);
                isUsed[i] = true;
                recursive(step + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                isUsed[i] = false;
            } else {
                switch(inputs[step]) {
                    case "<" -> {
                        if (sb.charAt(step - 1) - '0' < i) {
                            sb.append(i);
                            isUsed[i] = true;
                            recursive(step + 1, sb);
                            sb.deleteCharAt(sb.length() - 1);
                            isUsed[i] = false;
                        }
                    }
                    case ">" -> {
                        if (sb.charAt(step - 1) - '0' > i) {
                            sb.append(i);
                            isUsed[i] = true;
                            recursive(step + 1, sb);
                            sb.deleteCharAt(sb.length() - 1);
                            isUsed[i] = false;
                        }
                    }
                }
            }
        }
    }
}