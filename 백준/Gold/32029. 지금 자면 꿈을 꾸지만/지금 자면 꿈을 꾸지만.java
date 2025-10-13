import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int A;
    static int B;
    static int[] array;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        answer = noSleep();

       for (int i = 0; i <= N; i++) {
           for (int X = 1; X <= A - 1; X++) {
               answer = Math.max(answer, maxSleep(i, X));
           }
       }

        System.out.println(answer);
    }

    static int maxSleep(int sleepIndex, int X) {

        int time = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (i == sleepIndex) time += B * X;
            int workTime = i < sleepIndex ? A : A - X;
            if (time + workTime <= array[i]) {
                time += workTime;
                count++;
            }
        }

        return count;
    }

    static int noSleep() {

        int time = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (time + A <= array[i]) {
                time += A;
                count++;
            }
        }

        return count;
    }
}
