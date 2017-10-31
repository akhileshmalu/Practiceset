import java.util.Iterator;

/**
 * @author: Akhilesh Maloo
 * @date: 10/15/17.
 */

public class QueueDemo {

    private int[] nums;
    private int head = 0;
    private int tail = 0;

    QueueDemo() {
        nums = new int[1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(int i) {

        if(head == nums.length) resize(head*2);
        nums[head++] = i;
    }

    private void resize(int size2x) {

        int[] copyDoubleArray = new int[size2x];
        int i = 0;
        for(int j = tail; i < (head - tail); j++) {
            copyDoubleArray[i++] = nums[j];
        }
        tail = 0;
        head = nums.length;

        nums = copyDoubleArray;
    }

    public int dequeue() {
        if(tail < head && (head - tail) == nums.length/4) resize(nums.length/2);
        return nums[tail++];
    }


    public void showQueue() {
        for(int i = tail; i<head; i++) {
            System.out.println("Item is:" + nums[i]);
        }

    }

    public static void main(String[] args) {
        QueueDemo qd = new QueueDemo();
        qd.enqueue(10);
        qd.enqueue(20);
        qd.enqueue(30);
        qd.enqueue(20);
        //sd.showStack();
        qd.dequeue();
        qd.dequeue();
        qd.showQueue();
    }
}

