/**
 * Created by akhi on 5/20/17.
 */
public class PalindromNum {
    public boolean isPalindromNum(int x) {
        if(x < 0 || (x!=0 && x%10 == 0)) {
            return false;
        }
        int out = 0;
        while(x > out) {
            out = (10*out)+(x%10);
            x = x/10;
        }
        return x == out || x == out/10;
    }

    public static void main(String[] args) {
        PalindromNum ex = new PalindromNum();
        int x = 20;
        System.out.println(ex.isPalindromNum(x));

    }

}
