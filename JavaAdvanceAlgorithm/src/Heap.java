import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 10/22/17.
 */
public class Heap implements Iterable<Integer> {

    private Integer[] values;
    private int size;

    /**
     * Constructor takes initial array to build a heap
     * @param a
     */
    Heap(Integer[] a) {
        size = 0;
        buildHeap(a);
    }

    Heap() {
        size = 0;
        values = new Integer[1];
    }

    /**
     * build function to help parametrized constructor
     *
     * @param a
     */
    public void buildHeap(Integer[] a) {
        values = Arrays.copyOf(a,a.length);
        size = a.length;

        // (length / 2 - 1 ) is first parent of last child hence starts
        for(int i = (values.length/2)-1; i >= 0; i--) {
             minHeapify(i,size);
            //maxHeapify(i, size);
        }
    }

    /**
     * help to resize array if needed
     * @param newSize
     */
    public void resize(int newSize) {
        Integer[] newArr = Arrays.copyOf(values,newSize);
        values = newArr;
    }

    /**
     * Create a max heap from array
     * @param i : index of parent
     * @param n : size ; used for facilitating heapsort
     */
    public void maxHeapify(int i, int n) {
        int l = (2*i)+1;
        int r = (l) + 1;
        int z = i;

        if(l < n && values[z] < values[l])
            z = l;

        if(r < n && values[z] < values[r])
            z = r;

        if(z != i) {
            int swap = values[i];
            values[i] = values[z];
            values[z] = swap;
            maxHeapify(z, n);
        }
    }

    /**
     * Operation to heapUp new inserted max heap Value recursively
     * @param itemIndex : inserted item index
     */
    public  void maxHeapifyUp(int itemIndex) {

        // check if inserting item is first child of sec child
        int parent = (itemIndex%2==0)? (itemIndex / 2) - 1 : (itemIndex / 2);

        if(parent >= 0 && values[parent] < values[itemIndex]) {
            int swap = values[itemIndex];
            values[itemIndex] = values[parent];
            values[parent] = swap;

            maxHeapifyUp(parent);
        }

    }

    /**
     * Build min heap from values
     *
     * @param i: index of parent of last item
     * @param n: size of array ; used for heapsort
     */
    public void minHeapify(int i, int n) {
        int l = (2*i)+1;
        int r = (l) + 1;
        int z = i;

        if(l < n && values[z] > values[l])
            z = l;

        if(r < n && values[z] > values[r])
            z = r;

        if(z != i) {
            int swap = values[i];
            values[i] = values[z];
            values[z] = swap;
            minHeapify(z,n);
        }
    }

    /**
     * Used for heapUp for inserted Min heap value
     * @param itemIndex
     */
    public  void minHeapifyUp(int itemIndex) {

        // check if inserting item is first child of sec child
        int parent = (itemIndex%2==0)? (itemIndex / 2) - 1 : (itemIndex / 2);

        if(parent >= 0 && values[parent] > values[itemIndex]) {
            int swap = values[itemIndex];
            values[itemIndex] = values[parent];
            values[parent] = swap;

            minHeapifyUp(parent);

        }

    }


    /**
     * Insert item operation post build of heap
     * @param val
     */
    public  void insertItemInHeap(int val) {

        if(size == values.length) resize(2*size);
        values[size++] = val;
        minHeapifyUp(size-1);
        //maxHeapifyUp(size-1);
    }

    /**
     * HeapSort from available heap
     * ASC from MaxHeap
     * DESC from minHeap
     */
    public  void heapSort() {

        for(int i = size-1; i > 0; i--) {
            int swap = values[i];
            values[i] = values[0];
            values[0] = swap;

            //maxHeapify(0,i-1);
            minHeapify(0, i-1);
        }
    }

    public Node buildTreeFromHeap() {
        LinkedList<Node> q = new LinkedList<>();
        int i = 0;

        Node n = new Node(values[i]) ;
        Node root = n;

        q.add(root);

        while(q.size() != 0) {
            n = q.poll();
            if((2*i)+1 < size) {
                n.left = new Node(values[(2*i)+1]);
                q.add(n.left);
            }

            if((2*i)+2 < size) {
                n.right = new Node(values[(2*i)+2]);
                q.add(n.right);
            }
            i++;
        }
        return root;
    }

    /**
     *  If do not want to use Iterator and only print heap
     */
    public void printHeap() {
        for(int i = 0; i < size; i++)
            System.out.print(values[i] + " ");
        System.out.println();
    }

    void sink(int ind, int n) {
        int l = 2*(ind) + 1;
        int r = l + 1;
        int bigger = ind;
        if(r < n) { //both exists
            if(values[l] > values[r]) {
                bigger = l;
            } else {
                bigger = r;
            }
        } else if(l < n){
            bigger = l;
        }
        if(values[ind] < values[bigger]) {
            swap(values, bigger, ind);
            sink(bigger, n);
        }
    }

    void swim(int ind) {
        int parent = (ind - 1) / 2;
        if(parent >= 0 && values[parent] < values[ind]) {
            swap(values, parent, ind);
            swim(parent);
        }
    }

    void insert(int k) {
        if(size == values.length) resize(size * 2);
        values[size++] = k;
        swim(size-1);
    }

    int pop() {
        int head = values[0];
        values[0] = values[size-1];
        values[size-1] = null;
        size--;
        sink(0, size);
        return head;
    }

    void swap(Integer[] values, int a, int b) {
        int tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    class HeapIterator implements Iterator<Integer> {

        int current = 0;

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public Integer next() {
            int item = values[current];
            current += 1;
            return item;
        }

    }

    public static void main(String[] args) {
        int[] values = {3,2,1,6,0,5};



//        Heap hp = new Heap(values);
        Heap hp = new Heap();
        for(int val: values) {
            hp.insert(val);
        }
        //hp.insertItemInHeap(8);
//        hp.insertItemInHeap(7);

        //hp.heapSort();
//        hp.pop();
        hp.pop();
        hp.pop();
        for(Integer i: hp)
            System.out.print(i + " ");




//        Node node = hp.buildTreeFromHeap();
//        System.out.println(node.left.left.data);

    }
}
class Node {
    Node left, right;
    int data;

    Node(int k) {
        left = right = null;
        data = k;
    }
}
