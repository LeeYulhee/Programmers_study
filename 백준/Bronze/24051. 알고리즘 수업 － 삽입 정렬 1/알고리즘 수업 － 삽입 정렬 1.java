import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");

        int[] intArray = new int[Integer.parseInt(firstLine[0])];
        int target = Integer.parseInt(firstLine[1]);
        int count = 0;

        for(int i = 0; i < secondLine.length; i++) {
            intArray[i] = Integer.parseInt(secondLine[i]);
        }

        for(int i = 1; i < intArray.length; i++) {
            int beforeIndex = i - 1;
            int newItem = intArray[i];

            while(0 <= beforeIndex && newItem < intArray[beforeIndex]) {
                intArray[beforeIndex + 1] = intArray[beforeIndex];
                beforeIndex--;
                count++;
                if(count == target) System.out.println(intArray[beforeIndex + 1]);
            }
            if(beforeIndex + 1 != i) {
                intArray[beforeIndex + 1] = newItem;
                count++;
                if(count == target) System.out.println(intArray[beforeIndex + 1]);
            }
        }

        if(count < target) System.out.println(-1);
    }
}