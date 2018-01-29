package DataStructure;

import java.util.ArrayList;

/**
 * @author: Akhilesh Maloo
 * @date: 1/12/18.
 */
public class MyHashMap<K, V> {

    class HashNode<K, V> {
        K key;
        V val;
        HashNode next;

        HashNode() {
            this(null, null, null);
        }

        HashNode(K k, V v, HashNode n) {
            key = k;
            val = v;
            next = n;
        }

        public int hashCode() {
            int code = key.hashCode();
            code = (code * 31) + val.hashCode();
            return code;
        }

        public boolean equals(HashNode comp) {
            return this.key == comp.key && this.val == comp.val && this.hashCode() == comp.hashCode();
        }
    }

    ArrayList<HashNode<K, V>> bucket;
    private int numBucket = 17;
    private int size;

    MyHashMap() {
        bucket = new ArrayList<>();
        for (int i = 0; i < numBucket; i++)
            bucket.add(null);

        size = 0;
    }

    private int index(K k) {
        return k.hashCode() % numBucket;
    }

    public boolean containsKey(K k) {
        int i = index(k);
        HashNode tmp = bucket.get(i);
        if (tmp != null) {

            while (tmp != null) {
                if (tmp.key.equals(k)) {
                    return true;
                }
                tmp = tmp.next;
            }
        }
        return false;

    }

    public void put(K k, V v) {

        int i = index(k);
        HashNode tmp = bucket.get(i);

        if (tmp == null) {
            bucket.set(i, new HashNode<K, V>(k, v, null));
        } else {
            // check if key exist
            while (tmp != null) {
                if (tmp.key.equals(k)) {
                    tmp.val = v;
                    return;
                }
                tmp = tmp.next;
            }

            size++;
            HashNode head = bucket.get(i);
            HashNode node = new HashNode(k, v, head);
            bucket.set(i, node);

            // check load factor & resize
            if ((1.0 * size) / numBucket > 0.7) {
                resize();
            }

        }

    }

    private void resize() {
        // double the numBucket capacity
        numBucket = numBucket * 2;

        ArrayList<HashNode<K, V>> tmp = bucket;
        bucket = new ArrayList<>();

        for (HashNode<K, V> node : tmp) {
            while (node != null) {
                put(node.key, node.val);
                node = node.next;
            }
        }
    }

    public V get(K key) {

        int i = index(key);
        HashNode tmp = bucket.get(i);
        if (tmp != null) {

            while (tmp != null) {
                if (tmp.key.equals(key)) {
                    return (V) tmp.val;
                }
                tmp = tmp.next;
            }
        }
        return null;
    }

    public V remove(K key) {
        int i = index(key);
        HashNode tmp = bucket.get(i);
        HashNode pre = null;
        if (tmp != null) {

            while (tmp != null) {
                if (tmp.key.equals(key)) {
                    break;
                }
                pre = tmp;
                tmp = tmp.next;
            }

            // if key was not found
            if(tmp == null) {
                return null;
            }

            size--;
            V v = (V) tmp.val;

            // if found on first place
            if(pre == null) {
                bucket.set(i, tmp.next);
            } else {
                pre.next = tmp.next;
            }
            return v;
        }
        return null;
    }


    public static void main(String[] args) {

//        SeparateChainingHashMap<Integer, String> map = new SeparateChainingHashMap<>();
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Akhi");
        map.put(2, "John");
        map.put(3, "Snow");
        map.put(1, "Dow");
//        map.display();
        System.out.println(map.get(1));
        System.out.println(map.get(2));

        System.out.println(map.remove(1));
        System.out.println(map.get(1));


    }
}

