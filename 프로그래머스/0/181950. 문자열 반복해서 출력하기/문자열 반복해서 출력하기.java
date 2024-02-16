import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[1]);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            sb.append(inputArr[0]);
        }
        
        System.out.println (sb.toString());
    }
}