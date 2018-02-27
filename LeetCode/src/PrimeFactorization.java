import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Akhilesh Maloo
 * @date: 2/24/18.
 */
public class PrimeFactorization {

    public static List<Integer> factor(int num) {

        List<Integer> factors = new ArrayList<>();
        int[] primes = new int[num+1];
        for (int i = 2; i < primes.length; i++) {
            if(i % 2 == 0)
                primes[i] = 2;
            else
                primes[i] = i;
        }

        for (int i = 3; i < primes.length; i=i+2) {
            if(primes[i] == i) {
                for (int j = i*i; j < num; j = j + i) {
                    if(primes[j] == j)
                        primes[j] = i;
                }
            }
        }
        //Arrays.stream(primes).forEach(t -> System.out.print(t + " "));

        while(num > 0 && primes[num] > 0) {
            factors.add(primes[num]);
            num /= primes[num];
        }


        return factors;
    }

    public static void main(String[] args) {

        System.out.println(factor(100));

    }
}
