import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        int[] prefix = new int[size + 1];
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < size; i++) {
            prefix[i + 1] = Math.max(array[i] + prefix[i], array[i]);
        }

        for (int i = 1; i < prefix.length; i++) {
            answer = Math.max(prefix[i], answer);
        }

        System.out.println(answer);
    }
}