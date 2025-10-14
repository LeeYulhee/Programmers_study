import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최근에 나온 순서대로 과제 진행
        // 과제를 받으면 바로 시작
        // 새로운 과제를 받으면 하던 과제 중단 후 새 과제 시작
        // 과제 개수
        // 과제 여부(1 == true, 0 == false), 점수, 시간
        // => 과제가 들어오면 stack에 넣고 가장 최근 과제를 꺼내서 시간 - 1
        // => 시간이 0이 되면 totalScore에 +
        // 그럼 stack은 점수와 시간이 있어야 할 것 같은데

        int count = Integer.parseInt(br.readLine());
        int totalScore = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean isNewWork = st.nextToken().equals("1");

            // 새 과제가 들어오면
            // stack에 넣음
            if (isNewWork) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                stack.add(new int[]{score, time});
            }

            if (!stack.isEmpty()) {
                int[] nowWork = stack.pop();
                nowWork[1] = nowWork[1] - 1;

                if (nowWork[1] == 0) {
                    totalScore += nowWork[0];
                } else {
                    stack.add(nowWork);
                }
            }
        }

        System.out.println(totalScore);
    }
}