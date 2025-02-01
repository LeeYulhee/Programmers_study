import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int loopIndex;
    static int step;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        loopIndex = sc.nextInt();
        step = sc.nextInt();
        numbers = new int[loopIndex];        

        sc.nextLine();

        for (int i = 0; i < loopIndex; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        recursive(0, 0);

        System.out.println(sb.toString());
    }

    private static void recursive (int index, int depth) {

        if (step == depth) {
            sb.append(stack.toString().replace(",", "").replace("[", "").replace("]", ""));
            sb.append("\n");
            return;
        }

        depth++;

        for ( int i = index; i < loopIndex; i++) {
            if (stack.contains(numbers[i])) continue;

            stack.push(numbers[i]);
            recursive(i + 1, depth);
            stack.pop();
        }
    }
}