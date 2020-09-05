package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;
import com.silentao.util.PrintUtils;

/**
 * @Description
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Author Silence
 * @Date 2020/8/6 8:15
 **/
public class ReverseNodesGroup {

    /**
     * 将链表按k个一组断开，然后分组反转再连接起来
     * 最后不足k个就不处理
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        // 按k个分组
        for (int i = 1; i < k && node != null; i++) {
            node = node.next;
        }

        // 不足k个不处理
        if (node == null) {
            return head;
        }

        ListNode next = reverseKGroup(node.next, k);
        node.next = null;

        ListNode newHead = reverseListNode(head);

        head.next = next;

        return newHead;
    }

    /**
     * 递归反转单链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    /**
     * 线性反转单链表
     * @param head
     * @return
     */
    private static ListNode reverseListNode(ListNode head) {
        ListNode node = head;
        ListNode res = new ListNode(0);

        while (node != null) {
            ListNode cur = node;
            node = node.next;

            cur.next = res.next;
            res.next = cur;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;

        node.next = new ListNode(2);
        node = node.next;

        node.next = new ListNode(3);
        node = node.next;

        node.next = new ListNode(4);
        node = node.next;

        node.next = new ListNode(5);
        node = node.next;

        PrintUtils.print(head);
        ListNode res = reverseKGroup(head, 2);
        PrintUtils.print(res);
    }
}
