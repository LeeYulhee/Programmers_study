import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] result = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        for (int i = 1; i < N + 1; i++) {
            boolean[]    isVisited = new boolean[N + 1];
            int[]        stepCount = new int[N + 1];
            Queue<int[]> queue     = new LinkedList<>();

            isVisited[i] = true;

            for (int num : list.get(i)) {
                queue.add(new int[]{num,1});
            }

            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int index = arr[0];
                int step = arr[1];

                if (isVisited[index]) continue;

                isVisited[index] = true;
                stepCount[index] = step;
                
                for (int num : list.get(index)) {
                    queue.add(new int[]{num, step + 1});
                }
            }

            int totalStep = 0;

            for (int num : stepCount) {
                totalStep += num;
            }

            result[i] = totalStep;
        }

        int minNum = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 1; i < N + 1; i++) {
            if (minNum > result[i]) {
                minNum = result[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }
}