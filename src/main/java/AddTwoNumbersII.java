// https://leetcode.com/problems/add-two-numbers-ii/

import java.util.LinkedList;

public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode c1 = l1;
        ListNode c2 = l2;
        LinkedList<ListNode> a = new LinkedList();
        LinkedList<ListNode> b = new LinkedList();

        while (c1 != null || c2 != null) {
            if (c1 != null) {
                a.addLast(c1);
                c1 = c1.next;
            }
            if (c2 != null) {
                b.addLast(c2);
                c2 = c2.next;
            }
        }
        int carry = 0;
        int digit = 0;

        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty()) {
                digit = b.pollLast().val;
            } else if (b.isEmpty()) {
                digit = a.pollLast().val;
            } else {
                digit = a.pollLast().val + b.pollLast().val;
            }
            digit += carry;
            carry = digit > 9 ? 1 : 0;

            ListNode tmp = new ListNode(digit % 10);
            tmp.next = result;

            if (result == null) result = new ListNode(tmp.val);
            else result = tmp;
        }

        if (carry > 0) {
            ListNode tmp2 = new ListNode(carry % 10);
            tmp2.next = result;
            result = tmp2;
        }
        return result;
    }
}
