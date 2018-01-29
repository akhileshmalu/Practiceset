/**
 * @author: Akhilesh Maloo
 * @date: 1/14/18.
 */
public class MergeKList {

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

    public ListNode mergeDivide(ListNode[] lists, int start, int end) {
        if(start == end)
            return lists[start];

        if(start < end) {
            int mid = (start + end)/2;

            ListNode l1 = mergeDivide(lists, start, mid);
            ListNode l2 = mergeDivide(lists, mid+1, end);

            ListNode re = merge(l1, l2);
            return re;
        }
        return null;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeDivide(lists, 0, lists.length-1);
    }

    public static void main(String[] args) {

        MergeKList merge = new MergeKList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next= new ListNode(6);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(7);
        l3.next.next= new ListNode(9);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
//        lists[3] = l2;


        merge.mergeKLists(lists).display();

        System.out.println();

    }
}
