package org.problems.recursion;

import org.example.structure.linkedlist.ListNode;

/**
 * @author: Daniel
 * @date: 2021/4/12 4:27
 * @description:
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class LC24_Medium_SwapNodesInPairs {
    public static ListNode node4 = new ListNode(4);
    public static ListNode node3 = new ListNode(3, node4);
    public static ListNode node2 = new ListNode(2, node3);
    public static ListNode node1 = new ListNode(1, node2);

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LC24_Medium_SwapNodesInPairs solution = new LC24_Medium_SwapNodesInPairs();
        System.out.println("before swap");
        printLinkedList(node1);

        System.out.println("after swap");
        ListNode node5 = solution.swapPairs(node1);
        printLinkedList(node5);
    }
}
