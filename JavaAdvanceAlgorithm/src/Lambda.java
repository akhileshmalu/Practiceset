import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhi on 5/28/17.
 */
public class Lambda {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<Integer>();
        values.add(10);
        values.add(20);
//        Mylambda addLambda = (int a) -> a;
//        System.out.println(addLambda.add(3));

        values.forEach(a -> {
            System.out.println(++a);
        });

    }

}
//interface Mylambda {
//    int add(int a);
//}
