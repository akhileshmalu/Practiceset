import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akhilesh Maloo on 9/9/16.
 */
public class DistributeCandies {

    //@ Input param candies array of different type
    // @ Prob : Given an integer array with even length, where different numbers in this array represent different
    // kinds of candies Each number means one candy of the corresponding kind. You need to distribute these candies
    // equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
    // @ return unique maximum different type of candies sister can have.

    public static void main(String[] args) {
        int[] candies = {1,1,2,2,3,3};
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int maxDivision = candies.length/2;
        int i=0;

        while(count< maxDivision && i<candies.length) {
            if(!map.containsKey(candies[i])) {
                map.put(candies[i],1);
                // type of different candies count only
                count++;
            }
            i++;
        }
        System.out.println(map);
        System.out.println(count);

    }
}
