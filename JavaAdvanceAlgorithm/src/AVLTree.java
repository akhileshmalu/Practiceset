import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 9/15/17.
 */
public class AVLTree {
    Node root;

    AVLTree(int data) {
        root = new Node(data);
        root.height = 0;
    }

    class Node {
        private int data;
        private int height;
        private int rank;
        Node left;
        Node right;
        Node(int x) {
            data = x;
        }

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }


        public void insert(int val) {

            // reset height of tree;
            /*height = Math.max(
                    (left == null)? 0 : left.height,
                    (right == null)? 0 : right.height
            )+1;

*/

            rank = left.height+1;
            height++;
            if(val <= data) {
                if(left == null) {
                    left = new Node(val);
                    left.height = 0;
                } else {
                    left.insert(val);
                }

            } else {
                if(right == null) {
                    right = new Node(val);
                    right.height = 0;

                } else {
                    right.insert(val);
                }
            }


        }

        public boolean isBalanced(Node n) {

            if(balancedHeight(n) > -1)
                return true;
            else
                return false;
        }

        private int balancedHeight(Node n) {

            if(n == null) return 0;

            int h1 = balancedHeight(n.left);
            int h2 = balancedHeight(n.right);

            if(h1 == -1 || h2 == -1) return -1;
            if(Math.abs(h1-h2) > 1) return -1;

            if(h1 > h2)
                return h1 + 1;
            else
                return  h2 + 1;

        }


        public void printInOrder() {
            if(left != null)
                left.printInOrder();

            System.out.println("Data :"+ data + " Height of tree" + height);

            if(right != null)
                right.printInOrder();

        }

        public Node leftRotate(Node node) {
            Node tmp = node;
            tmp.right = node.right.left;
            node = node.right;
            node.left = tmp;

            return node;
        }

        public Node rightRotate(Node node) {
            Node tmp = node;
            tmp.left = node.left.right;
            node = node.left;
            node.right = tmp;

            return node;
        }
    }



    public static void main(String[] args) {

        int[] a = {2,1,5,4,6,7};
        AVLTree avl = new AVLTree(a[0]);

        for(int i = 1; i<a.length; i++)
            avl.root.insert(a[i]);

        avl.root.printInOrder();

    }
}


