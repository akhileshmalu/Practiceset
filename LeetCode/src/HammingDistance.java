import java.util.BitSet;

/**
 * Created by akhi on 5/17/17.
 */
public class HammingDistance {
    public static void main(String[] args) {

        int x = 3; // 011
        int y = 4; // 100 = > 111

        BitSet bits1 = new BitSet(32);
        int b = x ^ y;
        int count = 0;

        // Method 1 with 12ms
//        bits1 = BitSet.valueOf(new long[]{x^y});
//        System.out.println(bits1.cardinality());

        // Method 2 with least 9ms
        while(b > 0) {
            if((b & 1)== 1) {
                count++;
            }
            b = b >> 1;

        }
        System.out.println(count);
    }
}
