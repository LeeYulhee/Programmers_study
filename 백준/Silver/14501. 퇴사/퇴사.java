import java.util.Scanner;

public class Main {

    static int day;
    static int salary = Integer.MIN_VALUE;
    static int[][] schedule;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        day = sc.nextInt();
        schedule = new  int[day][2];

        for(int i = 0; i < day; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        recursive(0, 0);

        System.out.println(salary);
    }

    static void recursive(int index, int fee) {

        if ( index <= day ) {
            salary = Math.max(salary, fee);
        }

        if ( index >= day) return;

        recursive(index + schedule[index][0], fee + schedule[index][1]);
        recursive(index + 1, fee);


    }
}