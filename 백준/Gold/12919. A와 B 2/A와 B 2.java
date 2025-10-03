import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String start;
    static String target;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 문자열 S -> T
        // 연산 1 : 문자열 뒤에 A 추가
        // 연산 2 : 문자열 뒤에 B를 추가하고 뒤집기

        // 발상의 전환 1 : 방향을 거꾸로
        // 발상의 전환 2 : 진짜 문자열 만들지 않기
        // 일단 이 두 개를 기반으로 생각해보자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = br.readLine();
        target = br.readLine();

        recursive(target);

        System.out.println(answer);
    }

    // 재귀 멈출 수 있는 조건 : current의 길이가 start와 같은 경우
    static void recursive(String current) {
        if (current.length() == start.length()) {
            if (current.equals(start)) {
                answer = 1;
            }
            return;
        };

        if (current.charAt(current.length() - 1) == 'A') recursive(current.substring(0, current.length() - 1));
        if (current.charAt(0) == 'B') recursive(new StringBuilder(current.substring(1)).reverse().toString());
    }
}