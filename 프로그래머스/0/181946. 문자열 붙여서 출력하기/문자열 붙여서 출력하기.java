import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String s : inputArr) {
            sb.append(s);
        }
        
        System.out.println(sb.toString());
    }
}