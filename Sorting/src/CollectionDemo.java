import java.util.*;

/**
 * Created by akhi on 2/21/17.
 */
public class CollectionDemo {

    public void linkedListDemo() {

        LinkedList l1 = new LinkedList();

        l1.add("a");
        l1.add("k");
        l1.add("h");
        l1.add("i");
        l1.addFirst("Mr.");
        l1.addFirst(1);
        l1.set(0,'M');

        System.out.println("Original Content is : "+l1);
        System.out.println("Original Content is : "+l1.get(0));
        l1.remove();
//        l1.remove("a");
//        l1.remove(3);
        System.out.println("After Removal Content is : "+l1);

        Object val = l1.get(2);
        l1.set(2,(String)val+"changed");
        System.out.println("After Modification Content is : "+l1);
    }

    public void setDemo() {
        int[] count = {14,22,13,41,25};
        Set<Integer> set = new HashSet<Integer>();
        try {
            for (int value : count) {
                set.add(value);
            }
            System.out.println(set);


            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println("Sorted list is:");
            System.out.println(sortedSet);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        CollectionDemo demo = new CollectionDemo();
        demo.linkedListDemo();
       // demo.setDemo();
    }
}
