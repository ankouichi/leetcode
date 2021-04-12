package org.companies.paypal;

import org.example.structure.binarytree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

import static org.example.structure.binarytree.LevelOrder.printLevelOrder;

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

    public static void main(String[] args) {
        TreeNode node4 = TreeNode.generateCBT();
        printLevelOrder(node4);
        System.out.println();

//        System.out.println("Recursive Solution: ");
//        TreeNode inverted = solution.invertTree(node4);
//        solution.printLevelOrder(inverted);
//        System.out.println();

        System.out.println("Iterative Solution: ");
        TreeNode inverted2 = new LC226_InvertBinaryTree().invertTree2(node4);
        printLevelOrder(inverted2);
    }
}
