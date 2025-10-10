import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // X, Y가 주어지면 Y 순서대로 정렬(Y가 같으면 X 순서로 정렬)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[][] array = new int[count][2];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (a, b) -> {
            int result = Integer.compare(a[1], b[1]);
            if (result == 0) return Integer.compare(a[0], b[0]);
            return result;
        });

        StringBuilder sb = new StringBuilder();

        for (int[] arr : array) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        System.out.println(sb);
    }
}