import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 2/7/18.
 */
public class ReverseDoubleLinkedList {

    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode prev) {
            val = x;
            this.prev = prev;
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


    //  null <- 2 <-> 4 <-> 6 <-> 8 -> null
    //  4 <- 2 -> null
    // 6 <- 4 -> 2 -> null
    public static ListNode reverseDoubleList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;

        while(curr != null) {
            ListNode nxt = curr.next;

            curr.prev = curr.next;
            curr.next = pre;

            pre = curr;
            curr = nxt;

        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode ls = new ListNode(2);
        ls.next = new ListNode(4, ls);
        ls.next.next = new ListNode(6, ls.next);
        ls.next.next.next = new ListNode(8, ls.next.next);

        ListNode head = reverseDoubleList(ls);
        head.display();

    }
}
