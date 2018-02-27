/**
 * @author: Akhilesh Maloo
 * @date: 1/14/18.
 */
public class AlternateLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void display() {
            ListNode head = this;
            while(head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
    public static ListNode oddEvenList(ListNode head) {

        ListNode odd = head;

        ListNode even = odd.next;
        ListNode evenHead = even;


        while(even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

        }

        //merge both lists
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);

        ListNode alter = oddEvenList(l1);
        alter.display();

    }
}