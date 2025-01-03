import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.next());
        int term = sc.nextInt();
        int answer = Integer.MIN_VALUE;

        int[] array = new int[size];
        int[] prefix = new int[size + 1];

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < size; i++) {
            prefix[i + 1] = prefix[i] + array[i];
        }

        for (int i = term; i < prefix.length; i++) {
            answer = Math.max(prefix[i] - prefix[i - term], answer);
        }

        System.out.println(answer);
    }    
}