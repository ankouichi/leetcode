package org.problems.bt;

import org.example.structure.binarytree.InOrder;
import org.example.structure.binarytree.PreOrder;
import org.example.structure.binarytree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/4/29 23:13
 * @description:
 */
public class LC_105_Medium_ConstructBTFromInAndPreOrder {
    int[] preorder;
    int[] inorder;
    int prePtr;
    Map<Integer, Integer> inorderDict = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.prePtr = 0;
        int i = 0;
        for (int x : inorder)
            inorderDict.put(x, i++);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int root_val = preorder[prePtr++];
        int root_idx = inorderDict.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = build(left, root_idx - 1);
        root.right = build(root_idx + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] pre = {3,9,20,15,7};
        LC_105_Medium_ConstructBTFromInAndPreOrder app = new LC_105_Medium_ConstructBTFromInAndPreOrder();
        TreeNode root = app.buildTree(pre, in);
        List<Integer> inList = new InOrder().inorderTraversalByRecursion(root);
        for (int x : inList)
            System.out.print(x + " ");
        System.out.println();
        List<Integer> preList = new PreOrder().preorderTraversal(root);
        for (int x : preList)
            System.out.print(x + " ");
    }
}
