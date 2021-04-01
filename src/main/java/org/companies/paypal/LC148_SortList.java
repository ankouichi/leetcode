package org.companies.paypal;

import org.example.structure.linkedlist.ListNode;

/**
 * Created by ankouichi on 3/25/21
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 *
 * Since MergeSort Time complexity is O(n Log n) in all cases, so it's a good candidate.
 * It's a Divide and Conquer Algorithm, which contains two phases:
 * 1) Divide: recursively split original list into two halves.
 * 2) Merge: recursively sort each sublist and combine it into a single sorted list.
 *
 * Time Complexity - O(n*Log n)
 * Space Complexity - O(Log n): Since the problem is recursive, we need extra space to store the recursive call stack.
 * The maximum depth of the recursive tree is log n.
 *
 */

public class LC148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    /**
     * Split the given LinkedList into two parts
     * The method is somewhat different from the original fast-slow pointers approach.
     * @param head the head of the original linked list
     * @return the head of second half
     */
    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    /**
     * merge two sub linked list into one with ascending ordered elements
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = list1 != null ? list1 : list2;
        return dummyHead.next;
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // case: 4 2 1 3
        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node4 = new ListNode(4, node2);
        LC148_SortList solution = new LC148_SortList();
        solution.printLinkedList(node4);

        System.out.println();
        ListNode ordered = solution.sortList(node4);
        solution.printLinkedList(ordered);
    }
}
