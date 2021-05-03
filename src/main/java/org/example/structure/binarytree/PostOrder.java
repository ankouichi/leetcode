package org.example.structure.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ankouichi on 1/30/21
 */

public class PostOrder {
    public static void main(String[] args) {
        TreeNode node1 = TreeNode.generateCBT();
        List<Integer> list = new PostOrder().postorderTraversalIteratively(node1);
        System.out.println("Post Order: " + list);
    }

    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while ((cur != null) || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            TreeNode node = stack.pop();
            res.add(node.val);
//            System.out.println(res);
            if (!stack.isEmpty() && node.equals(stack.peek().left)) {
                cur = stack.peek().right;
            }
        }

        return res;
    }

}
