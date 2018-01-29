/**
 * @author: Akhilesh Maloo
 * @date: 1/14/18.
 */
public class SortLinkedList {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }


    public static void main(String[] args) {
        SortLinkedList sort = new SortLinkedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        l1.next.next.next.next.next = new ListNode(6);

        sort.sortList(l1).display();
    }
}
