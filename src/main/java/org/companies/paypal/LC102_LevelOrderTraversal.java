package org.companies.paypal;

import org.example.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ankouichi on 3/31/21
 */

public class LC102_LevelOrderTraversal {
    /**
     * Solution 1: 3 functions
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            List<Integer> levelList = new ArrayList<>();
            getNodesByHeight(root, i, levelList);
            ans.add(levelList);
        }
        return ans;
    }

    private static void getNodesByHeight(TreeNode node, int height, List<Integer> vals) {
        if (node == null) return;
        if (height == 1) vals.add(node.val);
        else {
            getNodesByHeight(node.left, height - 1, vals);
            getNodesByHeight(node.right, height - 1, vals);
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left > right) return left + 1;
        else return right + 1;
    }


    /**
     * Solution 2:
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    static List<List<Integer>> levels = new ArrayList<>();
    private static void helper(TreeNode node, int level) {
        if (levels.size() == level)
            levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    /**
     * Solution 3: BFS
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int level_len = queue.size();
            for (int i = 0; i < level_len; i++) {
                TreeNode tmpNode = queue.remove();
                levels.get(level).add(tmpNode.val);
                if (tmpNode.left != null)
                    queue.add(tmpNode.left);
                if (tmpNode.right != null)
                    queue.add(tmpNode.right);
            }
            level++;
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node5, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);

        for (List<Integer> levelList : levelOrder(node3)) {
            System.out.println(levelList);
        }

        System.out.println();
        for (List<Integer> levelList : levelOrder2(node3)) {
            System.out.println(levelList);
        }

        System.out.println();
        for (List<Integer> levelList : levelOrder3(node3)) {
            System.out.println(levelList);
        }
    }
}
