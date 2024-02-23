import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputArr = br.readLine().split(" ");
        
        int answer = Integer.parseInt(inputArr[0]) + Integer.parseInt(inputArr[1]);
        
        System.out.printf("%s + %s = %d", inputArr[0], inputArr[1], answer);
    }
}