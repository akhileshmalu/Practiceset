import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 11/21/17.
 */
public class Sum2 {

    public static void sum2(int[] nums, int target) {

        HashSet<Integer> visited = new HashSet<>();

        for(int num: nums) {

            if(visited.contains(target - num)) {
                System.out.println("{ " + num + " , " + (target-num) + " }");
            }
            visited.add(num);
        }

    }

    public static int[] twoSum(int[] numbers, int target) {


        HashMap<Integer, Integer> visit = new HashMap<>();

        for(int i= 0; i<numbers.length; i++) {
            if(visit.containsKey(target - numbers[i])) {
                int index = visit.get(target - numbers[i]);
                if(i < index) {
                    return new int[]{i, index};
                } else {
                    return new int[]{index, i};
                }
            }
            visit.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int[] val =  {4, 6, 5, -10, 8, 5, 5, 20};
        int[] r = twoSum(val,10);
        System.out.println(r[1]);

    }
}
