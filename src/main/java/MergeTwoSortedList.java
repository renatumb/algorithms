//https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedList {


    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_4 = new ListNode(4);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_3 = new ListNode(3);
        ListNode l2_4 = new ListNode(4);

        l1_1.next = l1_2;
        l1_2.next = l1_4;
        l1_4.next = null;
        l2_1.next = l2_3;
        l2_3.next = l2_4;
        l2_4.next = null;

        ListNode current = mergeTwoLists(l1_1, l2_1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode c;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        c = head;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    c.next = l1;
                    l1 = l1.next;
                } else {
                    c.next = l2;
                    l2 = l2.next;
                }
                c = c.next;
            }
            if (l1 == null) {
                c.next = l2;
                break;
            }
            if (l2 == null) {
                c.next = l1;
                break;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
