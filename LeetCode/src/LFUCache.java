import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Akhilesh Maloo
 * @date: 1/13/18.
 */
public class LFUCache {

    private int cap;
    private LinkedHashMap<Integer, Node> cache;
    //private Map<Node, Integer> freq;
    //private Node head, tail;

    class Node {
        int key;
        int val;
        int count;
        //Node next, prev;

        Node() {
            this(0,0,0);
        }

        Node(int k, int v, int c) {
            key = k;
            val = v;
            count = c;
        }

        public boolean equals(Node comp) {
            return comp.key == this.key && comp.val == this.val && comp.count == this.count;
        }
    }

    public LFUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>();
        //freq = new HashMap<>();
        //head = tail = null;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node tmp = cache.get(key);
            tmp.count++;
            cache.remove(key);
            cache.put(key, tmp);
            System.out.println(tmp.val);
            return tmp.val;
        } else {
            System.out.println(-1);
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cap == 0)
            return;

        // Node n = new Node(key, value, 1);
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            n.count++;
            n.val = value;
            cache.remove(key);
            cache.put(key, n);
        } else {
            if(cache.size() >= cap) {
                removeLFUNode();
            }
            cache.put(key, new Node(key, value, 1));
        }
    }

    public void removeLFUNode() {
        int min = Integer.MAX_VALUE;
        int key = 0;
        for(Node n : cache.values()) {
            if(n.count < min) {
                min = n.count;
                key = n.key;
            }
        }
        cache.remove(key);
    }


    public static void main(String[] args) {

        LFUCache mem = new LFUCache(2);

        mem.put(2,1);   //2
        mem.put(3,2);   //3 2
        mem.get(3);     // 3 - 1, 2
        mem.get(2);     //3-1, 2-1
        mem.put(4,3);   // 4-0,  2-1
        mem.get(2);     //
        mem.get(3);
        mem.get(4);



    }
}
