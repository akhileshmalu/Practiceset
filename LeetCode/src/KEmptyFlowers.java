import java.util.TreeSet;

/**
 * @author: Akhilesh Maloo
 * @date: 10/20/17.
 */
public class KEmptyFlowers {

    /**
     * @link https://leetcode.com/problems/k-empty-slots/description/
     * time complexity (n Log n)
     * @param P
     * @param K
     * @return
     */
    public static int FlowerBloom(int[] P, int K) {
        // write your code in Java SE 8

        TreeSet<Integer> bloomings = new TreeSet<>();
        int day = 0;

        for (int i = 0; i < P.length; i++) {
            day += 1;
            bloomings.add(P[i]);
            Integer left = bloomings.lower(P[i]);
            Integer right = bloomings.higher(P[i]);

            if (left == null) left = 0;

            if (P[i] - left - 1 == K ||
                    right != null && right - P[i] - 1 == K)
                return day;
        }
        return -1;
    }

    /** Time complexity (n^n)
     *
     * @param flowers
     * @param k
     * @return
     */
    public static int kEmptySlots(int[] flowers, int k) {

        String blooms = new String((new char[flowers.length])).replaceAll("\0", "0");
        String match = new String(new char[k]).replaceAll("\0", "0");
        int day = 0;

        for (int flower : flowers) {
            day++;
            char flw[] = blooms.toCharArray();
            flw[flower - 1] = ' ';

            blooms = new String(flw);

            if (blooms.matches("(.*)" + " " + match + " " + "(.*)"))
                return day;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] p = {1,3,2};
        System.out.println(FlowerBloom(p,1));
        System.out.println("Expected Out" + 2);
        System.out.println("Explanation: In the second day, the first and the third flower have become blooming.");
    }
}
