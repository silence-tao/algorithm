package com.silentao.leetcode.tree;

import com.silentao.structures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 * @Author Silence
 * @Date 2020/8/1 8:33
 **/
public class PathSum {

    /**
     * 层序遍历，然后挨个节点往下遍历，直到遍历到空节点
     * 然后把遍历路径的节点值相加，和等于sum计数加1
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res += helper(node, 0, sum);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }

    private int helper(TreeNode root, int temp, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }

        temp += root.val;
        if (temp == sum) {
            res++;
        }

        res += helper(root.left, temp, sum);
        res += helper(root.right, temp, sum);

        return res;
    }
}
