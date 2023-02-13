import javafx.util.Pair;

import java.util.*;

/**
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author: Akhilesh Maloo
 * @date: 2/14/18.
 */
public class KMostFreqItems {

    /**
     * Fastest Solution
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> getKMostFreq(int[] nums, int k) {

        List<Integer> res = new ArrayList<Integer>();
        int min = nums[0];
        int max = nums[0];

        for (int n : nums) {
            min = min < n ? min : n;
            max = max > n ? max : n;
        }
        int[] data = new int[max - min + 1];
        for (int n : nums) {
            data[n - min]++;
        }

        List[] bucket = new List[nums.length + 1];
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] > 0) {
                if (bucket[data[i]] == null)
                    bucket[data[i]] = new ArrayList<Integer>();

                List<Integer> list = bucket[data[i]];
                list.add(i + min);
                bucket[data[i]] = list;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            System.out.print(bucket[i] + " ");
        }

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        if(k > nums.length)
            return null;

        List<Integer> freq = new ArrayList<Integer>();

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            return (Integer)b.getValue() - (Integer)a.getValue();
        });


        HashMap<Integer, Integer> map = new HashMap<>();
        // keep a count
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        // convert count into pq max
        for(Map.Entry e : map.entrySet()) {
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }

        // k times pop
        while(k-- > 0) {
            freq.add((Integer)pq.poll().getKey());
        }

        return freq;

    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        if(k > nums.length)
            return null;

        List<Integer> freq = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // keep a count
        int min = nums[0];
        int max = nums[0];
        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List[] bucket = new List[nums.length];

        // convert count into pq max
        for(Map.Entry e : map.entrySet()) {

            int index = (int)e.getValue();

            if(bucket[index] == null)
                bucket[index] = new ArrayList<>();

            List<Integer> list = bucket[index];
            list.add((Integer)e.getKey());
            bucket[index] = list;
        }

        // k times pop
        for(int i = bucket.length-1; i >= 0 && freq.size() < k; i--) {
            if(bucket[i] != null)
                freq.addAll(bucket[i]);
        }

        return freq;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,1,2,2,3};
        System.out.println(topKFrequent2(num,2));

    }
}
