package com.silentao.leetcode.tree;

import com.silentao.structures.tree.TreeNode;

import java.util.ArrayList;

/**
 * @Description
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @Author Silence
 * @Date 2020/6/29 22:12
 **/
public class KTHSmallestElementInBST {

    /**
     * 根据中序遍历结果的 k - 1 位置就是结果
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = dfs(root, new ArrayList<>());

        return res.get(k - 1);
    }

    /**
     * 中序遍历，并将结果放入ArrayList中
     * @param root
     * @param res
     * @return
     */
    private ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);

        return res;
    }
}
