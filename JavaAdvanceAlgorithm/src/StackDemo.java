import java.util.*;

/**
 * Created by akhi on 2/21/17.
 */
public class StackDemo {

    static void showPop(Stack st) {
        System.out.println("Pop ->");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("Stack is: "+st);

    }
    static void showPush(Stack st,int a) {
        st.push(new Integer(a));
        System.out.println("Push ("+a+")");
        System.out.println("Stack is: "+st);
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        int elem;
        System.out.println("Stake : "+st);
        showPush(st,20);
        showPush(st,30);
        showPush(st,40);
        showPush(st,50);
        showPop(st);
        showPop(st);

        elem = (Integer) st.peek();
        System.out.println("Peek is : "+elem);
    }

}
