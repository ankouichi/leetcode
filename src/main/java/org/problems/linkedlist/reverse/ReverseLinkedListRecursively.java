package org.problems.linkedlist.reverse;

import org.example.structure.linkedlist.ListNode;

/**
 * @author: Daniel
 * @date: 2021/5/16 22:35
 * @description:
 */
public class ReverseLinkedListRecursively {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHeadNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateExampleLinkedList();
        ListNode.printNodes(head);

        ListNode reversed = reverse(head);
        ListNode.printNodes(reversed);
    }
}
