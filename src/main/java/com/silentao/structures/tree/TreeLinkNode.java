package com.silentao.structures.tree;

/**
 * @Description
 * @Author Silence
 * @Date 2019/12/12 22:36
 **/
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    // 指向父节点的指针
    public TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
