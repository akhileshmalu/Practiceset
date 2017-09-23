import java.util.BitSet;
/**
 * Created by akhi on 2/20/17.
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bit1 = new BitSet(8);
        BitSet bit2 = new BitSet(8);

        BitSet bit3 = new BitSet(8);

        int hashing;

        for (int i =0; i<8; i++) {
           if((i%2) == 0) {
               bit1.set(i);
           }
           if ((i%4) == 0) {
               bit2.set(i);
           }
        }
        System.out.println("Bits 1 are :"+bit1);
        System.out.println("Bits 2 are :"+bit2);

        bit1.or(bit2);
        System.out.println("Bits 1 After And :"+bit1);
        System.out.println("Bits 2 after And :"+bit2);

        bit1.and(bit2);

        for (int i=0; i<8; i++) {
            if(i%2==0) {
                bit1.flip(i+5);
            }
        }
        System.out.println("Bits 1 After And :"+bit1);
        System.out.println("Bits 2 after And :"+bit2);

        hashing =  bit1.hashCode();
        System.out.println("with cryptic: " + hashing);

    }
}
