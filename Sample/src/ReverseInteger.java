/**
 * Created by akhi on 5/14/17.
 */
public class ReverseInteger {

    // Reverse digits of an integer.

    //Example1: x = 123, return 321
    //Example2: x = -123, return -321

    public static void main(String[] args) {

        int input = 1;
        long output = 0;
        while (input != 0) {
            output = (10 * output) + input % 10;
            input = input / 10;
        }
        if (output < Integer.MAX_VALUE && output > Integer.MIN_VALUE) {
            System.out.println(output);
        } else {
            System.out.println(0);
        }

    }
}
