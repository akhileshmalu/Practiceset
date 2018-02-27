import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 1/13/18.
 */
public class LRUCache {

    public class Node<K, V> {
        K key;
        V val;
        Node next, prev;

        Node() {
            key = null;
            val = null;
            next = prev = null;
        }

        Node(K k, V v) {
            key = k;
            val = v;
        }

        public boolean equals(Node comp) {
            boolean result = false;

            if (comp.key instanceof String) {
                result = (comp.key.equals(this.key));
            } else {
                result = comp.key == this.key;
            }

            if (comp.val instanceof String) {
                result = result && (comp.val.equals(this.val));
            } else {
                result = result && comp.val == this.val;
            }

            return result;
        }
    }

    private HashMap<Integer, Node> memory;
    private int cap;
    private Node head;
    private Node tail;

    public LRUCache(int cap) {
        memory = new HashMap<>();
        this.cap = cap;
        head = tail = null;
    }

    public void set(int key, int val) {

        // if already exist
        if (memory.containsKey(key)) {
            Node tmp = memory.get(key);
            tmp.val = val;
            memory.put(key, tmp);
            remove(tmp);
            setHead(tmp);
        } else {
            if (memory.size() >= cap) {
                memory.remove((int)tail.key);
                remove(tail);
            }
            Node node = new Node(key, val);
            // if its first entry
            if (head == null) {
                head = tail = node;
            } else {
                // otherwise add item to head pointer & reset head counter
//                node.next = head;
//                head.prev = node;
//                head = node;
                setHead(node);
            }
            memory.put(key, node);

        }
    }

    public void remove(Node tmp) {

        if(tmp.prev != null) {
            tmp.prev.next = tmp.next;
        } else {
            head = tmp.next;

        }

        if(tmp.next != null) {
            tmp.next.prev = tmp.prev;
        } else {
            tail = tmp.prev;

        }
    }

    public void setHead(Node tmp) {
        tmp.next = head;
        tmp.prev = null;

        if(head != null) {
            head.prev = tmp;
        }

        head = tmp;

        if(tail == null)
            tail = tmp;

    }

    public int get(int key) {
        if (memory.containsKey(key)) {
            Node tmp = memory.get(key);
            // move recent used to head
            remove(tmp);
            setHead(tmp);
            System.out.println((int)tmp.val);
            return (int)tmp.val;
        } else {
            System.out.println(-1);
            return -1;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.set(1, 1);
        cache.set(2, 2);    //1,2
        cache.set(3, 3);    // 2, 1
        cache.set(4, 4);    //  4, 2
        cache.get(4);       // -1
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.set(5, 5);    //  4, 2
        cache.get(1);       // -1
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);

        //cache.set(3, 2);
//        cache.get(2);   // returns 2 (not found)
        //cache.set(3,1);       // returns 3.
        //cache.set(4, 4);    // evicts key 1.
        //cache.get(3);       // returns -1 (not found)
        /*
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4


       cache.get(2);
        cache.set(2,6);
        //cache.display();
        cache.get(1);
        //cache.display();
        cache.set(1,5);
        cache.set(1,2);
        //cache.display();
        cache.get(1);
        //cache.display();
        cache.get(2);
        //cache.display();
        */

    }
}

class LinkedHashMapLRU {

    private int cap;
    private LinkedHashMap<Integer, Integer> cache;

    LinkedHashMapLRU(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>();
    }

    public void set(int key, int val) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        } else {
            //remove check only works when entry is new in map
            if(cache.size() >= cap) {
                //constant time remove first entry
                cache.remove((cache.entrySet()).iterator().next().getKey());
            }
        }
        cache.put(key,val);
    }

    public void display() {

        System.out.print("Values are: ");
        cache.values().forEach(t -> {System.out.print( t + " ");});
        System.out.println();
    }

    public void get(int key) {
        if(cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            System.out.println(val);
        } else {
            System.out.println(-1);
        }
    }

}