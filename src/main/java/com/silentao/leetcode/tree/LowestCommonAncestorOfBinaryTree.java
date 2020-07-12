package com.silentao.leetcode.tree;

import com.silentao.structures.tree.TreeNode;

/**
 * @Description
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author Silence
 * @Date 2020/7/4 10:08
 **/
public class LowestCommonAncestorOfBinaryTree {

    /**
     * 利用后序遍历：找到给定的p、q节点
     * 回溯遇到的第一个节点就是最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 1.left != null && right != null 表示找到了p、q节点
        // return root;就是最近公共祖先

        // 2.root == p || root == q表示找到p或q节点
        // return root;就是返回p或q节点
        if ((left != null && right != null) || root == p || root == q) {
            return root;
        }

        // 返回找到的p或q节点
        return left != null ? left : right;
    }
}
