/**
 * @author: Akhilesh Maloo
 * @date: 10/24/17.
 */
public class AddTwoNumber {

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


    private int carry = 0;

    /**
     * Best soltion so far uses above carry; you can create a driver function which can call below recursion with carry too.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // base case when both are equal length (compared next) || not equal length (compare null)
        if((l1.next == null) && (l2.next == null)) {

            ListNode n = new ListNode((l1.val+l2.val+carry)%10);

            if(l1.val + l2.val + carry > 9) {
                n.next = new ListNode((l1.val+l2.val+carry)/10);
            }
            return n;
        }

        ListNode head = new ListNode((l1.val + l2.val + carry) % 10);
        carry = (l1.val + l2.val + carry) / 10;

        // new listnode 0 if length of two linked list is not same.
        head.next = addTwoNumbers((l1.next == null)? new ListNode(0) : l1.next,
                (l2.next == null)? new ListNode(0) : l2.next);

        return head;
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

        AddTwoNumber ad = new AddTwoNumber();
        ListNode l1 = new AddTwoNumber.ListNode(1);
        l1.next = new ListNode(8);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l3 = ad.addTwoNumbers(l1,l2);

        System.out.println(l3.val);

    }

}


