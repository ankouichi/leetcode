package org.example.binarytree;

/**
 * Created by ankouichi on 1/30/21
 */

public class SubtreeProblem {
    /**
     * Solution 1
     * @param t
     * @return
     */
    public static String preorder(TreeNode t) {
        if (t == null)
            return "null";
        return "#" + t.val + " " + preorder(t.left) + " " + preorder(t.right);
    }

    /**
     * determine subtree or not
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s,t)) return true;
        return isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    /**
     * same tree
     * @param s
     * @param t
     * @return
     */
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(3, node4, node5);

        String s = preorder(node3);
        System.out.println("String of s: " + s);
        System.out.println();

        TreeNode node01 = new TreeNode(1,null,null);
        TreeNode node02 = new TreeNode(2, null, null);
        TreeNode node04 = new TreeNode(4,node01,node02);
//        TreeNode node04 = new TreeNode(4,node01,null);
        String t = preorder(node04);
        System.out.println("String of t: " + t);
        System.out.println();

        boolean isSub = s.contains(t);
        System.out.println("t is a substring of s: " + isSub);
        System.out.println();

        boolean isSubOrNot = isSubTree(node3, node04);
        System.out.println("t is a substring of s: " + isSubOrNot);
    }
}
