import java.util.HashMap;
import java.util.Map;

/**
 * @author: Akhilesh Maloo
 * @date: 11/21/17.
 */
public class SubArraySumK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int sum = 0;
        map.put(0,1);
        int res = 0;

        for(int i=0; i<len; ++i){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        System.out.println(map);

        return res;
    }

    public static void main(String[] args) {

        int[] val = {10, 10, 10};
        System.out.println(subarraySum(val,20));
    }
}
