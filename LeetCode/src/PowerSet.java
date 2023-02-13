import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 2/21/18.
 */
public class PowerSet {

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList());
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }

        System.out.println(res);
        return res;

    }

    public static List<List<Integer>> subsets3(int[] nums) {

        List<List<Integer>> power = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            power.add(createSubSet(nums, i));
        }

        System.out.println(power);
        return power;
    }

    public static List<Integer> createSubSet(int[] nums, int j) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if ((j & (1 << i)) != 0)
                list.add(nums[i]);
        }

        return list;
    }

    /**
     * Generic approach for all subset problems
     * @param nums
     * @return
     */
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackPowerSet(list, new ArrayList<>(), nums, 0);    // for duplicate problem use backtrackDuplicate function
        System.out.println(list);
        return list;
    }

    private static void backtrackPowerSet(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrackPowerSet(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrackPermute(list, new ArrayList<>(), nums);
        System.out.println(list);
        return list;
    }

    private static void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrackPermute(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void permutateWithSwaps(int[] k, int left, int right, List<List<Integer>> list) {

        if(left == right) {
            list.add(new ArrayList<>(Arrays.stream(k).boxed().collect(Collectors.toList())));
        }

        else {
            for(int i = left; i <= right; i++) {
                //swap
                swap(k, left, i);
                permutateWithSwaps(k, left +1, right,list);
                swap(k, left, i);
            }
        }
    }

    public static void swap(int[] k, int i, int j) {

        int tmp = k[i];
        k[i] = k[j];
        k[j] = tmp;
    }


    private void backtrackWithDuplicate(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackWithDuplicate(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombi(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrackCombi(int[] vals, int index, int target, List<Integer> tmpList, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = index; i < vals.length; i++) {
            if(i > 0 && vals[i] == vals[i-1]) continue;
            tmpList.add(vals[i]);
            backtrackCombi(vals, i, target - vals[i], tmpList, res);
            tmpList.remove(tmpList.size()-1);
        }


    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

//        powerSet(nums);

        permute(nums);

//        subsets3(nums);
    }
}
