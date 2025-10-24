import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 강의
        // 최대한 적은 수의 강의실 => 모든 강의
        // 한 강의실에서 동시에 2개 이상의 강의 진행 X
        // 강의의 종료시간과 다른 강의의 시작시간이 겹치는 것 OK
        // => 필요한 최소 강의실의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        List<int[]> lessons = new ArrayList<>();
        Queue<Integer> ends = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lessons.add(new int[]{start, end});
        }

        lessons.sort(Comparator.comparingInt(a -> a[0]));

        for (int[] arr : lessons) {
            if(!ends.isEmpty() && ends.peek() <= arr[0]) {
                ends.poll();
                ends.add(arr[1]);
            } else {
                ends.add(arr[1]);
            }
        }

        System.out.println(ends.size());
    }
}