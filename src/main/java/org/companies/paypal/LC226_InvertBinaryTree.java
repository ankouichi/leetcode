package org.companies.paypal;

import org.example.structure.binarytree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */

public class LC226_InvertBinaryTree {
    /**
     * Solution 1: Recursive
     * Since each node in the tree is visited only once,
     * Time - O(n), where n is the number of nodes in the tree.
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) return;
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        invert(node.left);
        invert(node.right);
    }

    /**
     * Solution 2: Iterative
     * Time - O(n)
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }

    private void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queue_len = queue.size();
            for (int i = 0; i < queue_len; i++) {
                TreeNode tmp = queue.remove();
                System.out.print(tmp.val + " ");
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode node4 = new TreeNode(4, node2, node7);

        LC226_InvertBinaryTree solution = new LC226_InvertBinaryTree();

        solution.printLevelOrder(node4);
        System.out.println();

//        System.out.println("Recursive Solution: ");
//        TreeNode inverted = solution.invertTree(node4);
//        solution.printLevelOrder(inverted);
//        System.out.println();

        System.out.println("Iterative Solution: ");
        TreeNode inverted2 = solution.invertTree2(node4);
        solution.printLevelOrder(inverted2);
    }
}
