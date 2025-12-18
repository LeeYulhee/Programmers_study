import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static boolean[][] isUsed;
    static int answer = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        // 2차원 배열 N * M
        // 거기서 이어진 숫자 4개를 더해서 나오는 최대 값 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        isUsed = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isUsed[i][j] = true;
                findTetromino(1, board[i][j], i, j);
                isUsed[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    static void findTetromino(int depth, int current, int i, int j) {
        if (depth == 4) {
            answer = Math.max(answer, current);
            return;
        }

        int[] directionX = new int[]{-1, 1, 0, 0};
        int[] directionY = new int[]{0, 0, -1, 1};

        for(int index = 0; index < directionX.length; index++) {
            int nextI = i + directionY[index];
            int nextJ = j + directionX[index];

            if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M || isUsed[nextI][nextJ]) continue;

            // 내가 볼 수 있는 건 방향 4개
            // 시작점에서 4방향을 계속 살피며 가야 함
            // 시작점을 찾는 for문을 밖으로 빼야 될 것 같고
            // 반복하는 건 4방향을 탐색하고 사용된 값인지 확인하는 것
            // 아니면 current에 더하기

            // 중간 요소에서 두 번이 나갈 수도 있는 건데..
            isUsed[nextI][nextJ] = true;

            if (depth == 2) findTetromino(depth + 1, current + board[nextI][nextJ], i, j);
            findTetromino(depth + 1, current + board[nextI][nextJ], nextI, nextJ);

            isUsed[nextI][nextJ] = false;
        }
    }
}