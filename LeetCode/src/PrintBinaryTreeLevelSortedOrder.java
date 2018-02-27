import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given a Binary tree, the task is to print its all level in sorted order;
 * Advanced version of print level order with a line break
 * <p>
 * input:
 * 7
 * /  \
 * 6    5
 * / \  / \
 * 4  3 2   1
 * Output :
 * 7
 * 5 6
 * 1 2 3 4
 * <p>
 * Input :
 * 7
 * /  \
 * 16    1
 * / \
 * 4   13
 * Output :
 * 7
 * 1 16
 * 4 13
 * <p>
 * <p>

 * @author: Akhilesh Maloo
 * @date: 2/2/18.
 */
public class PrintBinaryTreeLevelSortedOrder {

    /**
     * * Implementation idea :  Keep 1 normal Queue (Q) & 1 priorityQueue(to use sort values)
     * <p>
     * step 1. insert Null after putting root value in Q
     * step 2. using BFS push all child elements in PQ
     * step 3: when encounter Null (we inserted at start after root value - step 1) remove all the items from PQ and
     * while printing push them into Q. And insert another null. -> {ensure if pq is not empty}
     *
     * @param x
     */
    private void printOrderInSorted(Node x) {

        if (x == null)
            return;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        LinkedList<Node> q = new LinkedList<>();

        q.offer(x);

        // inserting our level order symbol = null
        q.offer(null);

        System.out.println(x.val);

        while (!q.isEmpty()) {

            Node temp = q.poll();

            if (temp == null) {

                // this condition is require to ensure that null should not be added if there are no ele in PQ
                if (!pq.isEmpty()) {

                    // take out all elements from PQ while printing and push them into Ordinary Queue
                    while (!pq.isEmpty()) {
                        Node out = pq.poll();
                        System.out.print(out.val + " ");
                        q.offer(out);
                    }
                    System.out.println();
                    // insert level order symbol
                    q.offer(null);
                }

            } else {
                if (temp.left != null) {
                    pq.offer(temp.left);
                }
                if (temp.right != null) {
                    pq.offer(temp.right);
                }
            }

        }

    }

    /**
     * Implementation idea: using BFS insert elements in queue for every level size of Queue
     * @param x
     */
    private void printOrderInSorted2(Node x) {

        if (x == null)
            return;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        LinkedList<Node> q = new LinkedList<>();

        q.offer(x);

        while (!q.isEmpty()) {

            int size = q.size();

            while(size > 0) {

                Node temp = q.poll();

                pq.offer(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.left);
                }
                size--;

            }

            while(!pq.isEmpty()) {
                System.out.print(pq.poll() + " ");
            }
            System.out.println();



        }

    }


    public static void main(String[] args) {
        PrintBinaryTreeLevelSortedOrder tree = new PrintBinaryTreeLevelSortedOrder();

        /* Let us construct the tree shown in above diagram */
        Node root = new Node(7);
        root.left = new Node(6);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(1);

        tree.printOrderInSorted(root);
//        tree.printVertical();
    }
}
