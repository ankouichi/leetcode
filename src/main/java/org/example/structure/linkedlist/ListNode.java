package org.example.structure.linkedlist;

/**
 * Created by ankouichi on 3/25/21
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateExampleLinkedList() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        return node1;
    }

    public static void printNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("NULL\n");
    }
}
