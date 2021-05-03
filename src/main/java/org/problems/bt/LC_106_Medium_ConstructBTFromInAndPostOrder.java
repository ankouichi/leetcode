package org.problems.bt;

import org.example.structure.binarytree.InOrder;
import org.example.structure.binarytree.PostOrder;
import org.example.structure.binarytree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/4/29 23:00
 * @description:
 */
public class LC_106_Medium_ConstructBTFromInAndPostOrder {
    int postPtr;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> inorderDict = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        this.postPtr = postorder.length - 1;
        int i = 0;
        for (int x : inorder)
            inorderDict.put(x, i++);

        return build(0, postorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int root_val = postorder[postPtr];
        int root_idx = inorderDict.get(root_val);
        TreeNode root = new TreeNode(root_val);
        postPtr--;
        root.right = build(root_idx + 1, right);
        root.left = build(left, root_idx - 1);
        return root;
    }

    public static void main(String[] args) {
        LC_106_Medium_ConstructBTFromInAndPostOrder app = new LC_106_Medium_ConstructBTFromInAndPostOrder();
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode root = app.buildTree(in, post);
        List<Integer> inList = new InOrder().inorderTraversalByRecursion(root);
        for (int x : inList)
            System.out.print(x + " ");
        System.out.println();
        List<Integer> postList = new PostOrder().postorderTraversalIteratively(root);
        for (int x : postList)
            System.out.print(x + " ");
    }
}
