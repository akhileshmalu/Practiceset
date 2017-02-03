import java.util.Vector;
/**
 * Created by akhi on 2/21/17.
 */
public class VectorDemo {
    public static void main(String[] args) {

        Vector item = new Vector(3,2);
        System.out.println("Vector size " + item.size());
        System.out.println("Vector capacity " + item.capacity());

        item.addElement(new Integer(4));
        item.addElement(new Integer(2));
        item.addElement(new Integer(1));
        item.addElement(new Integer(6));

        System.out.println("Vector size " + item);
        System.out.println("Vector capacity " + item.capacity());

        System.out.println("First element is: "+ item.firstElement());

        System.out.println("Does Contain 3 ?: "+ item.contains(new Integer(3)));

//        System.out.println("elements are: "+ item.elements());


    }

}
