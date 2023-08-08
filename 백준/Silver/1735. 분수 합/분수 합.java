import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineInput = br.readLine().split(" ");
        String[] secondLineInput = br.readLine().split(" ");

        int a = Integer.parseInt(firstLineInput[0]);
        int b = Integer.parseInt(firstLineInput[1]);
        int c = Integer.parseInt(secondLineInput[0]);
        int d = Integer.parseInt(secondLineInput[1]);

        int numerator = a * d + b * c;
        int denominator = b * d;

        System.out.println(numerator / gcd(numerator, denominator) + " " + denominator / gcd(numerator, denominator));

    }

    static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}