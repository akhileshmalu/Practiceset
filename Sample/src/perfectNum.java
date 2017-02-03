/**
 * Created by akhi on 5/14/17.
 */
public class perfectNum {
    public static void main(String[] args) {
        int num = 1;
        int sum = 1;
        int i=2;

        if(num == 1) {
            System.out.println("true");
        }
        while(i<=Math.sqrt(num)) {
            if(num%i == 0) {
                sum +=i+num/i;
            }
            i++;
        }
        if(sum == num) {
            System.out.println("true");
        }
    }
}
