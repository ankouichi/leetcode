package org.problems.recursion;

import org.example.structure.binarytree.TreeNode;

/**
 * @author: Daniel
 * @date: 2021/4/14 21:28
 * @description:
 */
public class LC98_ValidateBinarySearchTree {
    /**
     * Approach 1: Recursion + Upper/Lower Bounds
     * Time - O(), Space - O()
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper)) {
            return false;
        }

        return valid(node.left, lower, node.val) && valid(node.right, node.val, upper);
    }

    private Integer prev;

    /**
     * Approach 2: Inorder Traversal + BST Property(left < root < right)
     * Each value traversed next should be larger than previous one.
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode node) {
        if (node == null) return true;
        if (!inorder(node.left)) return false;
        if (prev != null && node.val <= prev) return false;
        prev = node.val;
        return inorder(node.right);
    }

    public static void main(String[] args) {

    }
}
