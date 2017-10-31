/**
 * @author: Akhilesh Maloo
 * @date: 10/24/17.
 */
public class AddTwoNumber {

    public static ListNode addTwo(ListNode l1, ListNode l2, int carry, ListNode res) {

        int l1Val = 0, l2Val = 0;

        if(l1 != null)
            l1Val = l1.val;

        if(l2 != null)
            l2Val = l2.val;

        if(l1.next == null && l2.next == null) {
            ListNode n = new ListNode((l1Val + l2Val + carry)%10);
            carry = (l1Val + l2Val + carry) / 10;
            if(carry > 0)
                n.next = new ListNode(carry);
            return n;
        } else {

            res = new ListNode((l1Val + l2Val + carry) % 10);
            carry = (l1Val + l2Val + carry) / 10;

            ListNode nxt1 = new ListNode(0);
            ListNode nxt2 = new ListNode(0);

            if(l2.next == null) {

                nxt1 = l1.next;
            } else if(l1.next == null) {

                nxt2 = l2.next;
            }  else {
                nxt1 = l1.next;
                nxt2 = l2.next;
            }

            res.next = addTwo(nxt1, nxt2, carry, res.next);

        }
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        return addTwo(l1,l2, 0, res);
    }


    /**
     * Without Recursion
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            // create sum node
            ListNode tailNode = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            tailNode.val = sum % 10;
            carry = sum / 10;

            // assign it as tail of final res
            res.next = tailNode;
            // final list points to curr
            res = tailNode;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;  // first node excluded
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1,l2);

        System.out.println(l3.val);

    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

