package org.problems.recursion;

//import org.example.structure.binarytree.LevelOrder;
import org.example.structure.binarytree.TreeNode;

/**
 * @author: Daniel
 * @date: 2021/4/12 5:24
 * @description:
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 10^7
 * root is a binary search tree.
 * 1 <= val <= 10^7
 *
 * ATTENTION: Since it's a BST, then take care of the property: left < root < right
 *
 */
public class LC700_Easy_SearchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
//        TreeNode node = TreeNode.generateBST();
//        LevelOrder.printLevelOrder(node);
//        int val = 2;
//        TreeNode result = searchBST(node, val);
//        LevelOrder.printLevelOrder(result);
    }
}
