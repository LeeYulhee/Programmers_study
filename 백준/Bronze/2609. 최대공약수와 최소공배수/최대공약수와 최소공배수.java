import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().split(" ");

        int a = Integer.parseInt(strArray[0]);
        int b = Integer.parseInt(strArray[1]);

        System.out.println(gcd(a, b));
        System.out.println(a * (b / gcd(a, b)));
        
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        if (b % a == 0) return a;

        int c = a % b;
        b = b % a;
        return gcd(c, b);
    }
}