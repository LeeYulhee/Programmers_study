import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 6개의 줄
        // 플랫 : 각 줄마다 1 ~ P개
        // 플랫을 여러개 누르면 가장 높은 플랫 소리
        // 플랫을 한 번 누르거나 떼는 것 == 손가락 1회 움직임
        // => 손가락이 가장 적게 움직이는 횟수

        // Map이나 List로 Stack 받기
        // Stack.peek()한 값 > 플랫 번호 : 작을 때/빌 때까지 빼기 & 스택에 추가 => count++
        // Stack.peek()한 값 < 플랫 번호 : 스택에 추가 => count++
        // Stack.peek()한 값 = 플랫 번호 : 아무 변화 없음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputLines = Integer.parseInt(st.nextToken());
        int flats = Integer.parseInt(st.nextToken());
        int count = 0;

        Map<Integer, Stack<Integer>> map = new HashMap<>();

        for (int i = 0; i < inputLines; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = map.computeIfAbsent(line, a -> new Stack<>());

            for (int j = 0; j < flats; j++) {
                if (!stack.isEmpty() && stack.peek() >= flat) {
                    if (stack.peek() == flat) continue;
                    stack.pop();
                    count++;
                } else {
                    stack.add(flat);
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}