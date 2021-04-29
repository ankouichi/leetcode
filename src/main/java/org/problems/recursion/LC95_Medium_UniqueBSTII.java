package org.problems.recursion;

import org.example.structure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Daniel
 * @date: 2021/4/14 18:24
 * @description:
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
public class LC95_Medium_UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left_trees = generateTrees(start, i - 1);
            List<TreeNode> right_trees = generateTrees(i + 1, end);

            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
