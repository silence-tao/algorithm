package com.silentao.leetcode.tree;

import com.silentao.structures.tree.TreeNode;

/**
 * @Description
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Author Silence
 * @Date 2020/7/7 19:56
 **/
public class ValidateBinarySearchTree {

    /**
     * 前序遍历
     * 每次遍历需传入子树中的最大值和最小值
     * 其中左子树的最大值为当前根节点的值，最小值使用上一次的最小值
     * 其中右子树的最小值为当前根节点的值，最大值使用上一次的最大值
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    /**
     * 前序遍历
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // [10,5,15,null,null,6,20]

        int val = root.val;
        // 先遍历根节点，根节点不满足性质则返回false
        if (min != null && val <= min) {
            return false;
        }

        if (max != null && val >= max) {
            return false;
        }

        // 再遍历左右子树
        return isValid(root.left, min, val) && isValid(root.right, val, max);
    }
}
