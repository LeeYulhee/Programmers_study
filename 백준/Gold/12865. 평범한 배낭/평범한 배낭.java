import java.util.*;

public class Main {

    static int     count;
    static int     maxWeight;
    static int[][] things;
    static int[][]   dp;
    static int     salary;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        maxWeight = sc.nextInt();
        things = new int[count][2];
        dp = new int[count + 1][100001];

        for (int i = 0; i < count; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive (int index, int weight) {

        if ( weight > maxWeight ) return Integer.MIN_VALUE;

        if ( index == count ) return 0;

        if ( dp[index][weight] != -1 ) return dp[index][weight];

        dp[index][weight] = Math.max( recursive(index + 1, weight + things[index][0]) + things[index][1], recursive(index + 1, weight) );

        return dp[index][weight];
    }
}