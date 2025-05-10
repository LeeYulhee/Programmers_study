import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 'L') {
                    boolean[][] visited = new boolean[n][m];
                    int[][] dist = new int[n][m];

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{y, x});
                    visited[y][x] = true;

                    int localMax = 0;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cy = cur[0];
                        int cx = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int ny = cy + dy[d];
                            int nx = cx + dx[d];

                            if (ny >= 0 && ny < n && nx >= 0 && nx < m &&
                                map[ny][nx] == 'L' && !visited[ny][nx]) {

                                visited[ny][nx] = true;
                                dist[ny][nx] = dist[cy][cx] + 1;
                                localMax = Math.max(localMax, dist[ny][nx]);
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }

                    maxDistance = Math.max(maxDistance, localMax);
                }
            }
        }

        System.out.println(maxDistance);
    }
}