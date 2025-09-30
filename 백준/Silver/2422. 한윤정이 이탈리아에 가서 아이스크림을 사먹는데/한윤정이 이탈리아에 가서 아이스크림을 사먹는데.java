import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1부터 N까지의 아이스크림 종류 => 3가지 조합
        // 어떤 조합은 맛이 없음 => 이 조합의 개수가 M개(추가 입력으로 주어짐)
        // 가능한 방법의 개수(중복 X)

        // 전부 조합해보기
        // 다만 중복은 안 되니까 3중 for문을 돌 때, i, j, k가 각각 + 1이 되어야 함(섞이지 않게)
        // 조합하면 안 되는 값이면 continue => 이거 확인하는 방법 think => Map에 넣고 확인하는 걸로 하는 게 낫지 않을까?
        // continue가 안 되면 count++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int types = Integer.parseInt(st.nextToken());
        int notCombinationCount = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> notCombination = new HashMap<>();

        for(int i = 0; i < notCombinationCount; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            notCombination.computeIfAbsent(num1, k -> new ArrayList<>()).add(num2);
            notCombination.computeIfAbsent(num2, k -> new ArrayList<>()).add(num1);
        }

        for(int i = 1; i < types - 1; i++) {
            for(int j = i + 1; j < types; j++) {
                for (int k = j + 1; k <= types; k++) {
                    if (notCombination.get(i) != null) {
                        if (notCombination.get(i).contains(j) || notCombination.get(i).contains(k)) continue;
                    }
                    if (notCombination.get(j) != null) {
                        if (notCombination.get(j).contains(k)) continue;
                    }

                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}