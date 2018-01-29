import  java.util.*;
/**
 * @author: Akhilesh Maloo
 * @date: 1/18/18.
 */
public class FindMedian {

    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue( Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }

    public static void main(String[] args) {
        FindMedian obj = new FindMedian();
        obj.addNum(1);
        obj.addNum(7);
        obj.addNum(5);
        obj.addNum(4);
        obj.addNum(12);

        System.out.println(obj.findMedian());
    }
}
