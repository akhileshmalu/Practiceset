/**
 * @purpose: LinkedList Operations
 *
 * @author: Akhilesh Maloo
 * @date: 9/19/17.
 */
public class ReverseLinkedList {

    static Node head;

    static class Node {
        Node next;
        int value;

        Node(int data) {
            value = data;
            next = null;
        }
    }


    /**
     * @purpose: Reverse linked list
     * @param head Node
     * @return Node
     *
     * @runtime: time complexity O(n) & space Complexity O(1)
     */
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {


        ReverseLinkedList list = new ReverseLinkedList();
        head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
