import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Akhilesh Maloo
 * @date: 2/20/18.
 */
public class CloneLinkedList {

    static class DoubleListNode {
        int val;
        DoubleListNode next;
        DoubleListNode prev;

        DoubleListNode(int x) {
            val = x;
        }

        DoubleListNode(int x, DoubleListNode n, DoubleListNode p) {
            val = x;
            next = n;
            prev = p;
        }
    }

    /**
     * space O(1)
     * @param head
     * @return
     */
    public static DoubleListNode cloneList(DoubleListNode head) {
        // 1. create copy of node after nth node;
        DoubleListNode curr = head;

        while(curr!=null) {
            DoubleListNode next = curr.next;
            curr.next = new DoubleListNode(curr.val);
            curr.next.next = next;
            curr = next;
        }

        curr = head;

        // 2. set random pointers ;
        while (curr != null) {
            curr.next.prev = curr.prev.next;
            curr = curr.next.next;
        }

        DoubleListNode original = head;
        DoubleListNode clone = head.next;
        DoubleListNode cloneHead = clone;


        // 3 seperate original vs cloned
        while(original != null && clone != null) {
            original.next = (original.next != null)? original.next.next:original.next;
            clone.next = (clone.next != null)? clone.next.next:clone.next;
            original = original.next;
            clone = clone.next;
        }


        //return clone head;
        return cloneHead;
    }

    /**
     * Iterative solution
     * @param head
     * @return
     */
    public static DoubleListNode cloneLinkedList(DoubleListNode head) {

        HashMap<Integer, DoubleListNode> map = new HashMap<>();

        DoubleListNode k = new DoubleListNode(head.val);

        DoubleListNode curr = head;

        map.put(head.val, k);

        while(curr != null) {

            if (curr.next != null && !map.containsKey(curr.next.val)) {
                map.put(curr.next.val, new DoubleListNode(curr.next.val));
            }

            if (curr.prev != null && !map.containsKey(curr.prev.val)) {
                map.put(curr.prev.val, new DoubleListNode(curr.prev.val));
            }

            if (curr.next != null) {
                map.get(curr.val).next = map.get(curr.next.val);
            }
            if (curr.prev != null) {
                map.get(curr.val).prev = map.get(curr.prev.val);
            }

            curr = curr.next;
        }

        //dfs(head, map); // iterative with dfs

        return map.get(k.val);
    }

    /**
     * recursive with dfs
     * @param k
     * @param map
     */
    public static void dfs(DoubleListNode k, HashMap<Integer, DoubleListNode> map) {

//        map.put(k.val, new ReverseDoubleLinkedList.ListNode(k.val));
        if (k == null)
            return;

        if (k.next != null && !map.containsKey(k.next.val)) {
            map.put(k.next.val, new DoubleListNode(k.next.val));
        }

        if (k.prev != null && !map.containsKey(k.prev.val)) {
            map.put(k.prev.val, new DoubleListNode(k.prev.val));
        }

        if (k.next != null) {
            map.get(k.val).next = map.get(k.next.val);
        }
        if (k.prev != null) {
            map.get(k.val).prev = map.get(k.prev.val);
        }

        dfs(k.next, map);
    }

    public static void main(String[] args) {
        DoubleListNode l1 = new DoubleListNode(1);
        DoubleListNode l2 = new DoubleListNode(2);
        DoubleListNode l3 = new DoubleListNode(3);
        DoubleListNode l4 = new DoubleListNode(4);
        DoubleListNode l5 = new DoubleListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        l1.prev = l3;
        l2.prev = l1;
        l3.prev = l5;
        l4.prev = l3;
        l5.prev = l2;

        DoubleListNode cloneHead = cloneList(l1);
        //System.out.println(cloneHead.val);

        // 1 - 1 2 - 2- 3- 3- 4- 4- 5-5


        while (cloneHead != null) {
            System.out.println(cloneHead.val + " ");
            cloneHead = cloneHead.next;
        }
    }
}
