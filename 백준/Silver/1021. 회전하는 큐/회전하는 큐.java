import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        // 큐의 크기 N
        // 뽑을 숫자 M
        // 2, 3번 연산을 몇 번 해야 되는지 출력
        // 2번 연산 == 첫 번째 값을 뽑아서 맨 뒤로 보내기
        // 3번 연산 == 마지막 값을 뽑아서 맨 앞으로 넣기
        // => Deque 써야 할 것 같은데

        // 일단 큐에 1 ~ N까지 수로 채우기
        // 2번 연산이 나은지 3번 연산이 나은지 판단 필요
        
        // 간단하게 생각해보자. 지금 시점에서 앞으로 가져오는 게 빠르냐 뒤로 보내서 찾는 게 빠르냐잖아.
        // 그럼 중간을 기점으로 생각해볼 수 있을 것 같은데, 중간보다 앞의 값이면 뒤로 보내는 게 빠르고, 중간보다 뒤의 값이면 앞으로 가져오는 게 빠르고
        // 그럼 큐의 size 기준으로 그 값이 어느 위치에 있는지 어떻게 찾을까?

        // 1 2 3 4 5 6 7 8 9 10
        // 2 3 4 5 6 7 8 9 10 1 : 2번 연산
        // 3 4 5 6 7 8 9 10 1  => 2 뽑음
        // 1 3 4 5 6 7 8 9 10   : 3번 연산
        // 10 1 3 4 5 6 7 8 9   : 3번 연산
        // 9 10 1 3 4 5 6 7 8   : 3번 연산
        // 10 1 3 4 5 6 7 8    => 9 뽑음
        // 1 3 4 5 6 7 8 10     : 2번 연산
        // 3 4 5 6 7 8 10 1     : 2번 연산
        // 4 5 6 7 8 10 1 3     : 2번 연산
        // 5 6 7 8 10 1 3 4     : 2번 연산
        // 6 7 8 10 1 3 4      => 5 뽑음

        // 2, 3번 연산이 번갈아 일어날 일은 없음
        // 그러니까 두 가지 경우를 전부 봐도 되지 않을까? 그리고 횟수가 더 작은 경우를 사용하는 거지
        // 그럼 분기는 2개 : 뒤로 넘기거나 앞으로 넘겨서 poll 값이 target 숫자인 경우까지의 횟수 찾기
        // 근데 해당 회차에서 가장 최소값을 찾는다고 그게 다음 target에서도 최소인 값이 될 수 있을까?
        // 일단 각 단계의 최소가 최선이라는 가정 하에 진행해보자

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            

            Deque<Integer> secondDeque = new LinkedList<>(deque);
            Deque<Integer> thirdDeque = new LinkedList<>(deque);

            if (deque.getFirst() == target) {
                deque.pollFirst();
                continue;
            }

            int second = secondCase(target, 0, secondDeque);
            int third = thirdCase(target, 0, thirdDeque);

            if (second <= third) {
                answer += second;
                deque = secondDeque;
            } else {
                answer += third;
                deque = thirdDeque;
            }
        }

        System.out.println(answer);
    }

    static int secondCase(int target, int count, Deque<Integer> deque) {
        if (deque.getFirst() == target) {
            deque.pollFirst();
            return count;
        }

        int current = deque.pollFirst();
        deque.addLast(current);
        count += 1;

        return secondCase(target, count, deque);
    }

    static int thirdCase(int target, int count, Deque<Integer> deque) {
        if (deque.getFirst() == target) {
            deque.pollFirst();
            return count;
        }

        deque.addFirst(deque.pollLast());
        count += 1;

        return thirdCase(target, count, deque);
    }
}