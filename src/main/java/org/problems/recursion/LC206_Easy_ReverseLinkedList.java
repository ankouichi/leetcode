package org.problems.recursion;

import org.example.structure.linkedlist.ListNode;

/**
 * @author: Daniel
 * @date: 2021/4/12 5:08
 * @description:
 */
public class LC206_Easy_ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        System.out.println("before reverse");
        LC24_Medium_SwapNodesInPairs.printLinkedList(LC24_Medium_SwapNodesInPairs.node1);
        System.out.println("after reverse");
        ListNode result = reverseList(LC24_Medium_SwapNodesInPairs.node1);
        LC24_Medium_SwapNodesInPairs.printLinkedList(result);
    }
}
