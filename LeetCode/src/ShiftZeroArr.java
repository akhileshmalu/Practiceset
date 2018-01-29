import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 1/20/18.
 */
public class ShiftZeroArr {

    public static void shiftZero(int[] vals) {

        int index = 0;
        for (int i = 0; i < vals.length; i++) {
            if(vals[i] != 0) {
                int swap = vals[index];
                vals[index] = vals[i];
                vals[i] = swap;
                index++;
            }
        }

    }


    public static void main(String[] args) {

        int[] val = {0, 0, 0, 0, 2, 3, 5, 0, 0};

        shiftZero(val);

        Arrays.stream(val).forEach(System.out::print);

    }
}
