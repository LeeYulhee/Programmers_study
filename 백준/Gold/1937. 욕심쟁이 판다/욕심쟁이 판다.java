import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                result = Math.max(result, recursive(x, y));
            }
        }
        System.out.println(result + 1);
    }

    static int recursive(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] > map[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], recursive(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }
}