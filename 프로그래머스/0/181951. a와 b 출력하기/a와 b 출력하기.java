import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = br.readLine().split(" ");
        
        for(int i = 0; i < strArr.length; i++) {
            char c = (char)('a' + i);
            System.out.println(c + " = " + strArr[i]);
        }
    }
}