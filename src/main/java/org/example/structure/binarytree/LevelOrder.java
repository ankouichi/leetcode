package org.example.structure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Daniel
 * @date: 2021/4/12 5:30
 * @description:
 */
public class LevelOrder {
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queue_len = queue.size();
            for (int i = 0; i < queue_len; i++) {
                TreeNode tmp = queue.remove();
                System.out.print(tmp.val + " ");
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            System.out.println();
        }
    }
}
