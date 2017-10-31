import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/23/17.
 */
public class AmazingNumber {

    /**
     * // amazing = {rank < index} 4 <> 4 < 0,  1 = 1,1,  2 = 2,2 , 7 <> 7<3;
     * @param p
     * @return
     */
    public static int countOfAmazing(int[] p) {

        TreeSet<Integer> ts = new TreeSet<>();

        ts.addAll(Arrays.stream(p).boxed().collect(Collectors.toList()));

        int count = 0;

        for(int i = 0; i< p.length; i++) {

            //System.out.println(p[i] + " rank is " + (ts.headSet(p[i]).size()+1));
            if((ts.headSet(p[i]).size())+1 <= i+1)
                count++;

        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] p = {4, 1, 2 ,7, 6};
        System.out.println(countOfAmazing(p));
    }
}
