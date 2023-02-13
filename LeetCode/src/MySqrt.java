/**
 * Created by akhi on 8/9/17.
 */
public class MySqrt {
    public int Sqrt(int x) {
        long divisor = (long) x;

        while(divisor * divisor > x)
        divisor = (divisor + x/divisor) / 2;

        return (int)divisor;
    }

    public int Sqrt2(int x) {

        if (x == 0) return 0;
        int[] startval = {0,1,3,10,31,100,316,1000,10000,31622,100000,316220};
        int index = digitCount(x);
        long start = startval[index-1];
        long end = startval[index];

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;

    }

    public int digitCount(int x) {
        int digits = 0;
        while(x != 0) {
            digits++;
            x = x / 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.Sqrt(10000));
    }
}
