import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String strA;
    static long B;
    static long answer = -1;
    static boolean[] isUsed;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        strA = st.nextToken();
        B = Long.parseLong(st.nextToken());

        array  = new int[strA.length()];
        isUsed = new boolean[strA.length()];

        for (int i = 0; i < strA.length(); i++) {
            array[i] = strA.charAt(i) - '0';
        }

        recursive(0, new StringBuilder());

        System.out.println(answer);
    }

    static void recursive(int depth, StringBuilder sb) {
        if (depth == array.length) {
            long current = Long.parseLong(sb.toString());
            long A = Long.parseLong(strA);

            if (current > answer && current < B) {
                answer = current;
            }

            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (isUsed[i]) continue;
            if (sb.toString().isEmpty() && array[i] == 0) continue;

            sb.append(array[i]);
            isUsed[i] = true;
            recursive(depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }
}