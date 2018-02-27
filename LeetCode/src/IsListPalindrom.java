import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 10/25/17.
 */
public class IsListPalindrom {
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

    public static ListNode reverse(ListNode l) {
        //create a reverse LinkedList and then compare both the lists
        ListNode curr = l;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    /**
     * Runtime n with space n with Queue
     * @param l
     * @return
     */
    public static boolean isListPalindrome(ListNode l) {
        //create a reverse LinkedList and then compare both the lists

        LinkedList<Integer> q = new LinkedList<>();
        ListNode curr = l;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null) {
            // add all the items in queue while reversing the list
            q.add((int) curr.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        while(prev != null) {
            // pick up first element and check with reversed list;
            if(q.poll() != prev.val)
                return false;
            prev = prev.next;
        }

        return true;

    }

    /**
     * Runtime n space(1)
     * @param l
     * @return
     */
    public static boolean isListPalindrome2(ListNode l) {
        // first find middle of list;

        ListNode head = l;

        ListNode ptr2x = l;
        ListNode ptr1x = l;

        while(ptr2x != null && ptr2x.next != null) {

            ptr1x = ptr1x.next;
            ptr2x = (ptr2x.next.next != null)? ptr2x.next.next : ptr2x.next;
        }

        ListNode temp = ptr1x;
        ptr1x = null;
        return isIdenticalRecursive(head,reverse(temp));
    }


    public static boolean isIdenticalRecursive(ListNode a, ListNode b) {

        if (a == null && b == null) {
            return true;
        }

        if (a.val != b.val)
            return false;
        else {
           if(a.next != null && b.next != null)  {
               return isIdenticalRecursive(a.next, b.next);
           }
        }
        return true;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = new ListNode(1);

        System.out.println(isListPalindrome2(l1));


    }
}