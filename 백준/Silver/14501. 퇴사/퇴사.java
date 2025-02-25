import java.util.Scanner;

public class Main {

    static int     day;
    static int[][] schedule;
    static int[]   dp;
    static int     salary;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        day = sc.nextInt();
        schedule = new int[day][2];
        dp = new int[day + 1];

        for (int i = 0; i < day; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        for (int i = 0; i <= day; i++) {
            dp[i] = -1;
        }

        System.out.println(recursive(0));
    }

    private static int recursive (int index) {

        if ( index == day ) return 0;

        if ( index > day - 1 ) return Integer.MIN_VALUE;

        if ( dp[index] != -1 ) return dp[index];

        dp[index] = Math.max( recursive(index + schedule[index][0]) + schedule[index][1], recursive(index + 1) );

        return dp[index];
    }
}