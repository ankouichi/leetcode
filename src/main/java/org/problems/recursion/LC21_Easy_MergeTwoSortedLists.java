package org.problems.recursion;

import org.example.structure.linkedlist.ListNode;

/**
 * @author: Daniel
 * @date: 2021/4/14 15:20
 * @description:
 */
public class LC21_Easy_MergeTwoSortedLists {
    /**
     * Approach 1: Recursion
     * Time - O(M + N), Space - O(M + N), where M is the length of l1, N is the length of l2
     * @param l1 Linked List 1
     * @param l2 Linked List 2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * Approach 2: Iteration
     * Time - O(), Space - O()
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void printLinkedList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.println("NULL\n");
    }

    public static void main(String[] args) {
        // l1 : 1 -> 2 -> 4
        ListNode node14 = new ListNode(4);
        ListNode node12 = new ListNode(2, node14);
        ListNode node11 = new ListNode(1, node12);
        System.out.print("l1: ");
        printLinkedList(node11);

        // l2 : 1 -> 3 -> 4
        ListNode node24 = new ListNode(4);
        ListNode node23 = new ListNode(3, node24);
        ListNode node21 = new ListNode(1, node23);
        System.out.print("l2: ");
        printLinkedList(node21);

        ListNode merged2 = mergeTwoLists2(node11, node21);
        System.out.println("after merged by iteration: ");
        printLinkedList(merged2);

        printLinkedList(node11);
        printLinkedList(node21);

//        Character.getNumericValue()

//        ListNode merged1 = mergeTwoLists(node11, node21);
//        System.out.println("after merged by recursion: ");
//        printLinkedList(merged1);
    }
}
