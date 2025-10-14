import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int totalScore = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean isNewWork = st.nextToken().equals("1");

            if (isNewWork) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                stack.add(new int[]{score, time});
            }

            if (!stack.isEmpty()) {
                int[] nowWork = stack.peek();
                nowWork[1]--;
                
                if (nowWork[1] == 0) {
                    totalScore += nowWork[0];
                    stack.pop();
                }
            }
        }

        System.out.println(totalScore);
    }
}