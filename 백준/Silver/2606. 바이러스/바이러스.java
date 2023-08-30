import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < connect; i++) {
            String[] strArray = br.readLine().split(" ");
            
            map.computeIfAbsent(Integer.parseInt(strArray[0]), k -> new ArrayList<>()).add(Integer.parseInt(strArray[1]));
            map.computeIfAbsent(Integer.parseInt(strArray[1]), k -> new ArrayList<>()).add(Integer.parseInt(strArray[0]));
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[computer + 1];
        int count = 0;
        
        queue.add(1);
        check[1] = true;
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            if(map.get(num) != null) {
                for(int i : map.get(num)) {
                    if(check[i] == false) {
                        queue.add(i);
                        check[i] = true;
                        count++;
                    }
                }
            }
            
            check[num] = true;
        }
        
        System.out.println(count);
    }
}