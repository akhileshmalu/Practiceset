/**
 * @author: Akhilesh Maloo
 * @date: 2/27/18.
 */
public class AddNumberString {

    public static double stod(char[] f) {
        double res = 0;
        int len = 0;

        for (int i = 0; i < f.length; i++) {
            if(f[i] == '.') {
                len = 1;
                continue;
            }
            res =  (res * 10) + (f[i] - '0');
            len *= 10;
        }

        return res / ((len == 0)? 1 : len);
    }


    public static void main(String[] args) {
        String a = "0.9";
        String b = "3.4";
        System.out.println(stod(b.toCharArray()) + stod(a.toCharArray()));
    }

}
