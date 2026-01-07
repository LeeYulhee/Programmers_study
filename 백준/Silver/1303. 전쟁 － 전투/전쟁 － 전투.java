import java.io.*;
import java.util.*;

public class Main {

    static String[][] board;
    static boolean[][] isVisited;

    static int[] directionX = new int[]{0, 0, 1, -1};
    static int[] directionY = new int[]{1, -1, 0, 0};

    static int N;
    static int M;
    static int B = 0;
    static int W = 0;
    // static int sum;

    public static void main(String[] args) throws IOException {
        // 가로세로로 이어져 있으면 제곱
        // 아니면 그 값만 더하기
        // W B 값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                board[i][j] = str[j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;

                int size = checkWidth(i, j, board[i][j]);
                int answer = size * size;

                if (board[i][j].equals("W")) W += answer;
                else B += answer;
            }
        }

        System.out.println(W + " " + B);
    }

    static int checkWidth(int i, int j, String type) {
        if (isVisited[i][j]) return 0;
        if (!board[i][j].equals(type)) return 0;

        isVisited[i][j] = true;
        int sum = 1;

        for (int direction = 0; direction < 4; direction++) {
            int nextY = i + directionY[direction];
            int nextX = j + directionX[direction];

            if (nextY >= 0 && nextY < M && nextX >= 0 && nextX < N) {
                sum += checkWidth(nextY, nextX, type);
            }
        }

        return sum;
    }
}