/**
 * @author: Akhilesh Maloo
 * @date: 2/14/18.
 */
public class ClosestElemBinTree {


    public static Integer getClosestNumber(int k, Node head) {

        if(head == null) {
            return null;
        }

        int minRootDist = Math.abs(head.val - k);
        int minLeftDist = (head.left != null)? Math.abs(head.left.val - k): Integer.MAX_VALUE;
        int minRightDist = (head.right != null)? Math.abs(head.right.val - k): Integer.MAX_VALUE;

        if(minRootDist < minLeftDist && minRootDist < minRightDist)
            return head.val;

        if(minLeftDist < minRightDist) {
            return getClosestNumber(k,head.left);
        } else {
            return getClosestNumber(k,head.right);
        }

    }


    public static void main(String[] args) {

        ClosestElemBinTree bt = new ClosestElemBinTree();

        Node head = new Node(9);
        head.left = new Node(4);
        head.right = new Node(17);
        head.left.left = new Node(3);
        head.left.right = new Node(6);
        head.right.right = new Node(22);
        head.right.right.left = new Node(20);

        System.out.println(getClosestNumber(12,head));

    }
}
