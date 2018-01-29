package DataStructure;

import java.util.Iterator;

/**
 * @author: Akhilesh Maloo
 * @date: 1/17/18.
 */
public class PriorityQueue<Key extends Comparable<Key>> implements Iterable<Key> {

    private Key[] pq;
    private int size;

    PriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        size = 0;
    }

    public void fillArray(Key k) {
        pq[++size] = k;
    }

    public void swimUp(int i) {
        while(i > 1 && less(i/2, i)) {
            swap(i/2, i);
            i = i/2;
        }
    }

    public void sinkDown(int i) {
        while(2*i <= size) {
            int l = 2*i ;

            if(l < size && less(l, l+1)) l++;
            if(!less(i, l)) break;

            swap(i,l);
            i = l;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public void insert(Key k) {
        pq[++size] = k;
        swimUp(size);
    }

    public Key maxDelete() {
        Key max = pq[1];
        pq[1] = pq[size];
        pq[size--] = null;
        sinkDown(1);
        return max;
    }

    @Override
    public Iterator<Key> iterator() {
        return new PqIterator();
    }

    class PqIterator implements Iterator<Key> {
        PriorityQueue<Key> copy;

        PqIterator() {
            copy = new PriorityQueue<Key>(size+1);
            for(int i = 1; i<=size; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return copy.size != 0;
        }

        @Override
        public Key next() {
            if (!hasNext()) try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return copy.maxDelete();

        }
    }

    /**
     * In order to check maxHeap Function; we need to create a dummy pq array with help of fillArray function;
     * @return boolean (true) if thats is a max heap
     *
     */
    public boolean isMaxHeap() {
        return isMaxHeapUtil(1);
    }

    private boolean isMaxHeapUtil(int n) {

        if(n >= size)
            return true;

        int l = 2*n;
        int r = 2*n + 1;

        if(l < size && pq[n].compareTo(pq[l]) < 0)
            return false;

        if(r < size && pq[n].compareTo(pq[r]) < 0)
            return false;

        return isMaxHeapUtil(l) && isMaxHeapUtil(r);

    }


    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(10);
        q.insert(1);
        q.insert(2);
//        q.insert(7);
//        q.insert(4);
//        q.insert(5);
//        q.insert(8);


//        q.fillArray(5);
//        q.fillArray(4);
//        q.fillArray(3);
//        q.fillArray(2);
//        q.fillArray(1);

        for(Integer k : q) {
            System.out.println(" val " + k + " ->");
        }




    }



}
