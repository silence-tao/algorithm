package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;

/**
 * @Description
 * 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @Author Silence
 * @Date 2020/4/22 0:54
 **/
public class DeleteNodeLinkedList {

    /**
     * 要删除一个节点，那么我们必须知道node节点的前一个节点
     * 这里是无法知道的
     * 但是我们可以把node.next的val复制到node上
     * 然后把node.next节点删除
     * 也能达到目的
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
