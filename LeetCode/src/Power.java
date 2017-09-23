/**
 * Created by akhi on 6/10/17.
 */
public class Power {
    //  Slow method
    public double myPow(double x, int n) {
        double prod = 1;
        int sign = 1;
        if(n == 1) {
            return x;
        }
        if (n<0) {
            sign = -1;
            if(n == -1) {
                prod = x;
            }
            n *= -1;
        }
        if( n > 1) {
            int first = n / 2;
            prod = myPow(x, first) * myPow(x, n-first);
//            n = n-first;
        }


        return sign != -1 ? prod : 1/prod;
    }

    // Faster 20 ms
    public double Pow(double x, int m) {
        double temp=x;
        if(m==0)
            return 1;
        temp=Pow(x,m/2);
        if(m%2==0)
            return temp*temp;
        else
        {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }

    }

    // Faster break on cases like 2, - MAX_INT -> 0
    public double Pow2(double x, int n) {
        double prod = 1;
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1/ x;
            n = -n;
        }
        return n%2 == 0 ? Pow2(x*x,n/2) : x*Pow2(x*x,n/2);
    }

    // Fast 25 ms
    public double Pow3(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }

    // fastest 18ms
    public double FastestmyPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n == 1)
            return x;

        //
        if (n < 0) {
            if (n < -Integer.MAX_VALUE)
                return FastestmyPow(x, n + 1)*(1/x);
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        if (n%2 == 0)
            return myPow(x*x, n/2);
        else
            return myPow(x*x, n/2)*x;
    }

    public static void main(String[] args) {
        Power pow = new Power();
        System.out.println(pow.FastestmyPow(2,
                -271271212));
    }
}
