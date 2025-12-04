import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int total = 0;
        int finalTime = Integer.MAX_VALUE;
        int finalHigh = 0;

        int[][] arr = new int[N][M];

        // 1. 블록을 제거해서 인벤토리에 넣기 : 2초
        // 2. 블록 쌓기 : 1초
        // 모든 요소들을 같은 값으로 맞추는 최소 시간과 그 높이

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        for (int high = 0; high <= 256; high++) {
            // 모든 블록을 재배치한다고 했을 때 도달할 수 있는 높이인지 판단
            if (high * (N * M) > total + B) break;

            int time = 0;

            // 목표 높이보다 요소의 높이가 크다면 빼기
            // 목표 높이보다 요소의 높이가 낮다면 추가하기

            for (int[] a : arr) {
                for (int i : a) {
                    if (i > high) {
                        time += (i - high) * 2;
                    } else {
                        time += (high - i);
                    }
                }
            }

            if (finalTime >= time) {
                finalTime = time;
                finalHigh = high;
            }
        }

        System.out.println(finalTime + " " + finalHigh);
    }
}