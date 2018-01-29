import java.util.Arrays;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 1/19/18.
 */
public class ShuffleList {

    public List<Integer> shuffleList(List<Integer> nums) {

        // border cases:
        if(nums == null) {
            return null;
        }

        if(nums.size() <= 1) {
            Arrays.asList(nums).forEach(System.out::print);
            return nums;
        }

        for(int i = 1; i < nums.size(); i++) {

            int randomIndex = (int)(Math.random() * i);
            Integer swap = nums.get(randomIndex);
            nums.set(randomIndex, nums.get(i));
            nums.set(i, swap);
        }

        Arrays.asList(nums).forEach(System.out::print);

        return nums;
    }
}
