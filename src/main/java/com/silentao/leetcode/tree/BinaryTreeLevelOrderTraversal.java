package com.silentao.leetcode.tree;

import com.silentao.structures.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Author chentao10
 * @Date 2020/5/13 9:50
 **/
public class BinaryTreeLevelOrderTraversal {

    /**
     * 层序遍历需要用队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 将整层的节点都放在这个集合中
            List<TreeNode> treeNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                treeNodes.add(queue.poll());
            }

            List<Integer> list = new ArrayList<>();
            // 然后遍历整层的节点
            for (TreeNode treeNode : treeNodes) {
                list.add(treeNode.val);
                // 并将节点的左右子节点放入队列中
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            res.add(list);
        }

        return res;
    }

    /**
     * 不用队列的方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 保存所有的节点
        List<TreeNode> treeNodes = new ArrayList<>();
        // st记录每层遍历的开始位置
        // len记录遍历的总长度
        int st = 0, len = 0;
        treeNodes.add(root);
        len++;
        while (st < len) {
            List<Integer> list = new ArrayList<>();
            int i = st, end = len;
            st = end;
            for (; i < end; i++) {
                TreeNode node = treeNodes.get(i);
                list.add(node.val);
                if (node.left != null) {
                    treeNodes.add(node.left);
                    len++;
                }

                if (node.right != null) {
                    treeNodes.add(node.right);
                    len++;
                }
            }

            res.add(list);
        }

        return res;
    }
}
