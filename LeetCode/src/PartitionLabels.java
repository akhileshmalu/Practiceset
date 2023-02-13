import java.util.ArrayList;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 3/26/18.
 */
public class PartitionLabels {

    public static List<Integer> getPartition(String str) {
        List<Integer> list = new ArrayList<>();
        char[] string = str.toCharArray();
        int[] alpha = new int[26];

        //store last index for char
        for(int i = 0; i<string.length; i++)
            alpha[string[i]-'a'] = i;

        int last = 0;
        int start = 0;
        // look for a place in string where last index is same as position & Max
        for(int i = 0; i<string.length; i++) {
            last = Math.max(last, alpha[string[i] - 'a']);

            // if reached to last index of max element;
            if(last == i) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(getPartition("ababcbacadefegdehijhklij"));
    }
}
