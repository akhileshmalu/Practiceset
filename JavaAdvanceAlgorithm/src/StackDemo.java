import java.util.*;

/**
 * Created by akhi on 2/21/17.
 */
public class StackDemo<Item> implements Iterable<Item>{


    // implementing a generic interator
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    public class StackIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() { return current != null; }
        public Item next() {
            Item item = current.num;
            current = current.next;
            return item;
        }


    }


    // Implementation with LinkedList
    public class Node {
        Item num;
        Node next;

        Node(Item n) {
            this.num = n;
        }

        Node() {

        }
    }

    public  Node first = null;


    public void push(Item val) {

        Node top = new Node(val);
        top.next = first;

        first = top;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item pop() {

        if(!isEmpty()) {

            Item k = first.num;
            first = first.next;
            return k;
        }

        return null;

    }

    /*
    public void showStack() {
        while(first != null) {
            System.out.println("Item is: " + first.num);
            first = first.next;
        }
    }*/


    /*
    // implementation with resizable array
    private int[] nums;
    private int N = 0;

    StackDemo() {
        nums = new int[1];
    }

    public void push(int val) {
        if(N == nums.length) resize(2*N);
        nums[N++] = val;

    }


    public int pop() {

        if(N > 0 && nums.length/4 == N) resize(nums.length/2);

        if(N > 0) {
            // int array cant be set to null for saving space
            return nums[--N];

        }
        return -1;
    }

    public void resize(int k) {

        int[] copyDoubleArray = new int[k];

        for(int i = 0; i< N; i++) {
            copyDoubleArray[i] = nums[i];
        }

        nums = copyDoubleArray;

    }

    public void showStack() {
        for(int i = N-1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }
    */


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

        /*
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
        System.out.println("Peek is : "+elem); */


        StackDemo<Integer> sd = new StackDemo<Integer>();
        sd.push(10);
        sd.push(20);
        sd.push(30);
        sd.push(20);
        sd.pop();
        sd.pop();

        for(int a: sd) System.out.println(a);


    }

}
