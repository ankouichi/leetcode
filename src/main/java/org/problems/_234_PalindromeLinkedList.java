package org.problems;

/**
 * Created by ankouichi on 2/15/21
 */

public class _234_PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(4, node1);
    ListNode node3 = new ListNode(-1, node2);
    ListNode node4 = new ListNode(-1, node3);
    ListNode node5 = new ListNode(4, node4);
    ListNode node6 = new ListNode(1, node5);

    public static void main(String[] args) {
        _234_PalindromeLinkedList app = new _234_PalindromeLinkedList();
        System.out.println(app.isPalindrome(app.node6));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode endOfFirstHalf = endOfFirstHalf(head);
        ListNode startOfSecondHalf = reverseList(endOfFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = startOfSecondHalf;
        boolean result = true;
        while (p2 != null && result) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        endOfFirstHalf.next = reverseList(startOfSecondHalf);

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
