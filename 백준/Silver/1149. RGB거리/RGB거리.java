import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for ( int i = 1; i <= N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        for ( int i = 1; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}