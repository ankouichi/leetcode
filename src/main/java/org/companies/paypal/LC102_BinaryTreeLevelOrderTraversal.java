package org.companies.paypal;

import org.example.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ankouichi on 3/25/21
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 */

public class LC102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> ans = new ArrayList<>();
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            List<Integer> tmpList = new ArrayList<>();
            getGivenLevel(root, i, tmpList);
            ans.add(tmpList);
        }
        return ans;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if (lHeight > rHeight) return lHeight + 1;
        else return rHeight + 1;
    }

    public void getGivenLevel(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;
        if (level == 1) list.add(root.val);
        else {
            getGivenLevel(root.left, level - 1, list);
            getGivenLevel(root.right, level - 1, list);
        }
    }

    /**
     * Approach 2: Time-O(), Space-O()
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> subList = new LinkedList<>();
                for(int i = 0; i < levelSize; i++) {
                    if (queue.peek().left != null) queue.offer(queue.peek().left);
                    if (queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                }

                res.add(subList);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
