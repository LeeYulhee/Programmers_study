import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 크레인 N대(~50) : 무게 초과로 못 옮김
        // 박스 M개
        // 전부 옮기는 최소 횟수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        // System.out.println(boxes);

        System.out.println(calculate(cranes, boxes, N));
    }

    private static int calculate (Integer[] cranes, List<Integer> boxes, int N) {
        if (cranes[0] < boxes.get(0)) return -1;

        int answer = 0;

        while (!boxes.isEmpty()) {
            int crane = 0;

            ListIterator<Integer> iterator = boxes.listIterator();
            while (iterator.hasNext() && crane < N) {
                if (cranes[crane] >= iterator.next()) {
                    iterator.remove();
                    crane++;
                }
            }

            answer++;
        }

        return answer;
    }
}