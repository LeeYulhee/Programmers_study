import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] array = new int[n][2];
        int[] dp = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }

        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(array[i][1] > array[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(n - (answer + 1));
    }
}