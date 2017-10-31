import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2 Side DS for specific operations
 *
 * @author: Akhilesh Maloo
 * @date: 10/21/17.
 */
public class Deck<Item> implements Iterable<Item> {

    private Item[] items;
    private static int head;
    private static int tail;


    public Deck() {
        // ugly type casting as java does not support generic array creation
        items = (Item[]) new Object[5];
        tail = items.length / 2;
        head = tail + 1;
    }

    public boolean isEmpty() {
        return head == tail +1;
    }

    public int size() {
        return head - tail - 1;
    }

    private void resize(int k) {
        Item[] arr = (Item[]) new Object[k];
        int l = size();

        for (int i = (k / 2) - 1; i < (k/2) + l; i++) {
            arr[i] = items[tail++];
        }
        head = k/2 + l;
        tail = (k / 2) - 1;

        items = arr;
    }

    public void addFirst(Item item) {

        try{

            if(item == null) {
                throw new IllegalArgumentException("Null Input on index: " + tail);
            }
            items[tail] = item;
            if (tail == 0) resize(items.length * 2 + 1);
            tail--;

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        }
    }

    public void addLast(Item item) {
        try{
            if(item == null) {
                throw new IllegalArgumentException("Null Input on index: " + (head - size()));
            }

            if (head == items.length) resize(items.length * 2 + 1);

            items[head] = item;
            head++;

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        }

    }

    public Item removeFirst() {
        if(!isEmpty()) {
            Item i = items[++tail];
            items[tail] = null;
            return i;
        } else {
            throw new NoSuchElementException("Tried to remove element which does not exist on index: " + tail);
        }
    }

    public Item removeLast() {
        if(!isEmpty()) {
            Item i = items[--head];
            items[head] = null;
            return i;
        } else {
            throw new NoSuchElementException("Tried to remove element which does not exist on index: " + head);
        }
    }

    /*
    public void showItems() {
        for (Item i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }*/

    public Iterator<Item> iterator() {

        return new DeckIterator();
    }

    public class DeckIterator implements Iterator<Item> {

        Item[] val = items;
        int current = tail+1;

        @Override
        public boolean hasNext() {
            return head != current;
        }

        @Override
        public Item next() {
            return val[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove Function not supported in Iterator");
        }
    }


    public static void main(String[] args) {

        Deck<String> d = new Deck();
        d.addFirst("A");
        d.addFirst("B");
        d.addFirst("C");
        d.addLast("D");
//        d.removeFirst();
//        d.removeFirst();
//        d.removeFirst();
//        d.addFirst(4);
        //d.removeLast();
        //System.out.println(d.size());


        for(String a: d) System.out.print(a + " ");
        System.out.println();


    }

}

