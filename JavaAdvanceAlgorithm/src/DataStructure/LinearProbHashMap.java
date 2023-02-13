package DataStructure;

import java.util.HashMap;

/**
 * @author: Akhilesh Maloo
 * @date: 1/12/18.
 */
class LinearProbHashMap<K, V> {

    private int M = 3001;
    private K[] keys = (K[]) new Object[M];
    private V[] values = (V[]) new Object[M];

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        int index = hash(key);
        for(int i = index; keys[i] != null; i = (i + 1) % M) {
            //search hit
            if(key.equals(keys[i]))
                return values[i];
        }
        //search miss
        return null;
    }

    public void put(K key, V value) {
        int index = hash(key);
        int i = 0;
        for(i = index; keys[i] != null; i = (i + 1) % M) {
            if(key.equals(keys[i])) {
                break;
            }
        }
        keys[i] = key;
        values[i] = value;
    }

    public void display() {
        for(int i = 0; i<M; i++) {
            if(keys[i] != null)
                System.out.println("Key: " + keys[i] + " | Value: " + values[i]);
        }
    }

}


