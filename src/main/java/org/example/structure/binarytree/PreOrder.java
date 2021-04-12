package org.example.structure.binarytree;

import java.util.*;

/**
 * Created by ankouichi on 1/30/21
 */

public class PreOrder {
    public static void main(String[] args) {
        TreeNode node1 = TreeNode.generateCBT();
        List<Integer> list = new PreOrder().preorderTraversal3(node1);
        System.out.println("Result by recursion: " + list);
        System.out.println();
//        List<Integer> list2 = new InOrder().inorderTraversalByIteration(node1);
//        System.out.println("Result by iteration: " + list2);
    }

    /**
     * Iterative Solution 1
     * @param root the root element
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while ((node != null) || !stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node.right);
                node = node.left;
            } else {
                node = stack.pop();
            }
        }

        return res;
    }

    /**
     * Iterative Solution 2
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        return res;
    }

    /**
     * Similar with Solution 1
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while ((cur != null) || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            }
            cur = stack.pop();
        }

        return res;
    }
}
