package org.example.structure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ankouichi on 1/29/21
 */

public class InOrder {
    public static void main(String[] args) {
        TreeNode node1 = TreeNode.testNode();
        List<Integer> list = new InOrder().inorderTraversalByRecursion(node1);
        System.out.println("Result by recursion: " + list);
        System.out.println();
        List<Integer> list2 = new InOrder().inorderTraversalByIteration(node1);
        System.out.println("Result by iteration: " + list2);
    }

    /// Recursive Approach
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursiveHelper(root, res);
        return res;
    }

    public void recursiveHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                recursiveHelper(root.left, res);
            }

            res.add(root.val);

            if (root.right != null) {
                recursiveHelper(root.right, res);
            }
        }
    }

    /// Iterative Solution 1
    public List<Integer> inorderTraversalByIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while ((cur != null) || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
