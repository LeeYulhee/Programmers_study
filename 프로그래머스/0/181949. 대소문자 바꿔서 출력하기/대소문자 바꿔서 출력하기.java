import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        
        for(String s : inputArr) {
            if(s.matches("[A-Z]")) {
                s = s.toLowerCase();
            } else {
                s = s.toUpperCase();
            }
            sb.append(s);
        }
        
        System.out.println(sb.toString());
    }
}