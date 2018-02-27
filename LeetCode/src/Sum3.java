
import java.util.*;
import java.util.stream.Collectors;

import Search.BinarySearch;

/**
 * @author: Akhilesh Maloo
 * @date: 10/1/17.
 */
public class Sum3 {

    /**
     * Provide if there exist a sum from 3 elements;
     *
     * @analysis: Time Complexity : N^2 log N ;  (N^2) for choosing 2 elements(a,b) and (log N) for BinSearch Sum - (a+b)
     * @param val
     * @param sum
     * @return List<Integer> set of 3 numbers summing upto target;
     */
    public static List<List<Integer>> sumOf3(int val[], int sum) {

        List<List<Integer>> sumOf3Sets = new ArrayList<>();
        Arrays.sort(val);       // Sort the arrays first

        for(int i = 0; i < val.length; i++) {
            for(int j = i+1; j < val.length; j++) {

                int k = BinarySearch.binarySearch(val, j+1, val.length-1,sum - (val[i] + val[j]));
                if(k != -1) {
                    List<Integer> newSet = new ArrayList<>();
                    //System.out.println("{ "+ val[i] + " " + val[j] + " " + val[k]);
                    newSet.addAll(Arrays.asList(val[i],val[j],val[k]));

                        if(!sumOf3Sets.contains(newSet))
                        sumOf3Sets.add(newSet);
                }
            }
        }
        return sumOf3Sets;

    }

    /**
     * N^3 solution
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> item = new HashSet<>();
        HashMap<Integer, Integer> balancer = new HashMap();


        for(int i = 0; i < nums.length; i++) {
            balancer.put(i , nums[i]);
        }

        for(int i = 0; i< nums.length; i++) {

            for(int j = i+1; j <nums.length; j++) {

                int r = (0 - (nums[i] + nums[j]) );

                if(balancer.containsValue(r)) {

                    List<Integer> ind = checkValueFromMap(balancer, r);

                    Iterator itr = ind.iterator();

                    while(itr.hasNext()) {
                        int pos = (int)itr.next();
                        if(pos > j) {
                            int min = Math.min(nums[i], Math.min(r, nums[j]));
                            int max = Math.max(nums[i], Math.max(r, nums[j]));
                            int middle = (0 - (min + max));

                            List<Integer> subItem = new ArrayList<>(Arrays.asList(min,middle,max));

                            if(!item.contains(subItem))
                                item.add(subItem);
                        }

                    }

                }

            }
        }

        for(List<Integer> a: item) {
            result.add(a.stream().collect(Collectors.toList()));
        }
        //System.out.println(item);
        return result;
    }

    public static List<Integer> checkValueFromMap(HashMap<Integer, Integer> balancer, int r) {
        List<Integer> indexs = new ArrayList<>();

        for(int i = balancer.size()-1 ; i >= 0; i--) {
            if(balancer.get(i) == r)
                indexs.add(i);
        }

        return indexs;
    }

    /**
     *@analysis N^2
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> sets = new ArrayList<>();
        Arrays.sort(nums);       // Sort the arrays first

        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i]-1) continue; // avoid duplicates
            for(int j = i+1, k = nums.length-1; j< nums.length && k > j;) {
                if(nums[i]+ nums[j]+ nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[i],nums[j],nums[k]));

                    if(!sets.contains(list))
                        sets.add(list);

                    while(j<k && nums[j] == nums[j+1]) j++; //avoid duplicate
                    while(j<k && nums[k] == nums[k-1]) k--; //avoid duplicate
                    j++;
                    k--;
                } else if(nums[i]+ nums[j]+ nums[k] < 0)
                        j++;
                else k--;

            }
        }
        return sets;
    }

    /**
     * Best Solution with out HashSet
     * @param nums
     * @return
     */
    public static List<List<Integer>> sum3(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
            for(int j = i+1, k = nums.length-1; j<k;) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
                    while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
                }else if(nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return list;

    }


    public static void main(String[] args) {
        int val[] = {1,2,3};
// /        System.out.println(threeSum2(val));
        //sum3(val);

    }
}
