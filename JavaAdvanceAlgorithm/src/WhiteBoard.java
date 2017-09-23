import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 9/5/17.
 */
public class WhiteBoard {


    public static int linearSearch(int[] arr, int target, int size) {

        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //code
        /*
        Scanner scanner = new Scanner(System.in);

        int testSize = scanner.nextInt();

        while (testSize > 0) {

            int arrSize = scanner.nextInt();

            int[] arr = new int[arrSize];

            for (int i = 0; i < arrSize; i++) {
                arr[i] = scanner.nextInt();
            }

            int target = scanner.nextInt();

            int searchResult = linearSearch(arr, target, arrSize);

            System.out.println("Output:");

            System.out.print(searchResult);

            testSize--;

        }
        */

        //code
        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int testSize = scanner.nextInt();

        while(testSize > 0) {

            int arrSize = scanner.nextInt();

            int[] arr = new int[100];

            for(int i = 0; i < arrSize; i++) {
                int a = scanner.nextInt();

                if(map.containsKey(a)) {
                    continue;
                } else {
                    map.put(a, i);
                }
            }

            int target = scanner.nextInt();

            if(map.containsKey(target)) {
                System.out.println(map.get(target));
            } else {
                System.out.println(-1);
            }
            //  System.out.println(linearSearch(arr, target, arrSize));

            testSize--;

        }


    }
}



