import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        long answer = 0;
        long sum = 0;

        int left = 0;
        int right = 0;

        while (left < N) {
            sum += arr[right];

            if (sum > K) {
                answer++;
            }

            if (right + 1 < N) {
                right++;
            } else {
                left++;
                right = left;
                sum = 0;
            }
        }

        System.out.println(answer);
    }
}