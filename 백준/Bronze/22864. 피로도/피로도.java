import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1시간
        // A만큼 피로 증가 => B만큼 처리
        // C만큼 피로 감소(처리 X)
        // 최대 피로도는 M 이하
        // 하루 최대 24시간

        // 24시간 동안 반복
        // 현재 피로 <= M이 아닐 때, 일
        // 현재 피로 + A <= M이 아닐 때 일(일 했을 때에도 M을 넘으면 안 됨)
        // 두 조건이 아니면(일할 수 없는 상태) 현재 - C

        Scanner sc = new Scanner(System.in);

        int addTired = sc.nextInt();
        int work = sc.nextInt();
        int minusTired = sc.nextInt();
        int maxTired = sc.nextInt();
        int currentTired = 0;
        int totalWork = 0;

        for(int i = 0; i < 24; i++) {
            if (currentTired <= maxTired && currentTired + addTired <= maxTired) {
                totalWork += work;
                currentTired += addTired;
            } else {
                currentTired = Math.max(currentTired - minusTired, 0);
            }
        }

        System.out.println(totalWork);
    }
}