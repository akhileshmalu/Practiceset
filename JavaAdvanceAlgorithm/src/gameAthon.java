import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 10/13/17.
 */
public class gameAthon {

    public static String game(long n) {
        boolean fenner = true;
        if (n == 1)
            return "FENNER";

        if (n < 0) {
            if (n == Long.MIN_VALUE) {
                return "BUELL";    // power of 63 will yield Fenner as winner
            } else {
                n = Long.MAX_VALUE + n + 1;
                fenner = false;
            }
        }

        while (n != 1) {
            long k = largestPowerOf2LessThanN(n);
            if (k * 2 == n) {
                int power = Long.toBinaryString(k * 2).length() - 1;
                if (power % 2 == 1) fenner = !fenner;
                break;
            } else {
                n -= k;
            }
            fenner = !fenner;
        }
        return (fenner) ? "FENNER" : "BUELL";
    }

    public static long largestPowerOf2LessThanN(long number) {
        return Long.highestOneBit(number - 1);
    }

    // 16;

    //driver function
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        try {
            int totalTest = key.nextInt();

            while(totalTest > 0) {
                long n = Long.parseUnsignedLong(key.next());
                System.out.println(game(n));
                totalTest--;
            }

        } catch (NumberFormatException e) {

        }

    }
}
