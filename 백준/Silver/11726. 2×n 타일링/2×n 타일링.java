import java.util.*;

public class Main {

    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }

            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}