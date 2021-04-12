package org.example.structure.binarytree;

/**
 * Created by ankouichi on 1/29/21
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *        1
     *    2       3
     * 4    5  null  6
     * @return
     */
    public static TreeNode generateCBT() {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);
        return new TreeNode(1, node2, node3);
    }

    public static TreeNode generateBST() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node6 = new TreeNode(6, node5, null);
        return new TreeNode(4, node2, node6);
    }
}
