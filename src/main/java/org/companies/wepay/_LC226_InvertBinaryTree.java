package org.companies.wepay;

import org.example.structure.binarytree.TreeNode;

/**
 * Created by ankouichi on 3/21/21
 */

public class _LC226_InvertBinaryTree {

    /**
     * Get the height of the tree
     * @param root root node
     * @return height of the given tree
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if (lHeight > rHeight) return lHeight + 1;
        else return rHeight + 1;
    }

    public void printGivenLevel(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print(root.val + " ");
        else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public void printLevelOrder(TreeNode root) {
        if (root == null) return;
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // case 1: [4 2 7 1 3 6 9]
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode node4 = new TreeNode(4, node2, node7);

        _LC226_InvertBinaryTree solution = new _LC226_InvertBinaryTree();
        System.out.println("Before Invert: ");
        solution.printLevelOrder(node4);
        System.out.println("After Invert: ");
        solution.printLevelOrder(solution.invertTree(node4));

        // case 2: []
    }
}
