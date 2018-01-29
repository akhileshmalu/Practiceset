package DataStructure;

/**
 * @author: Akhilesh Maloo
 * @date: 1/12/18.
 */
class SeparateChainingHashMap<K,V>  {

    private int M = 97;
    private int size = 0;
    Node[] table = new Node[M];

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        Node(Object key, Object value, Node nxt) {
            this.key = key;
            this.value = value;
            next = nxt;
        }

        public boolean equals(Node comp) {
            boolean result = false;

            if(comp.key instanceof String) {
                result = (comp.key.equals(this.key));
            } else {
                result = comp.key == this.key;
            }

            if(comp.value instanceof String) {
                result = result && (comp.value.equals(this.value));
            } else {
                result = result && comp.value == this.value;
            }

            return result;
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff ) % M;
    }

    public V get(K key) {
        int index = hash(key);
        for(Node i = table[index]; i != null; i = i.next) {
            if(key.equals(i.key))
                return (V) i.value;
        }
        return null;
    }

    public void put(K key, V val) {
        int index = hash(key);
        table[index] = new Node(key, val, table[index]);

    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void display() {
        for(int i = 0; i< M; i++) {
            Node curr = table[i];
            if(curr != null) {
                System.out.print(" Key : " + curr.key);
                while(curr != null) {
                    System.out.print(" Value: " + curr.value + " | ");
                    curr = curr.next;
                }
                System.out.println();
            }
        }
    }


}

