import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        
        if(n <= 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }
}