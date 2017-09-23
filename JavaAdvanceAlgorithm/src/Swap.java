/**
 * Created by akhi on 9/9/16.
 */
public class Swap {
    public static void swap(MyInt a,MyInt b)
    {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {

        MyInt a = new MyInt(Integer.parseInt(args[0]));
        MyInt b = new MyInt(Integer.parseInt(args[1]));

        swap(a,b);
        System.out.println(a.value + " " + b.value);
    }
}
