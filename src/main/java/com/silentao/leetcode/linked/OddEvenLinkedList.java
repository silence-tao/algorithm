package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;
import com.silentao.util.PrintUtils;

/**
 * @Description
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @Author Silence
 * @Date 2020/4/22 23:35
 **/
public class OddEvenLinkedList {

    /**
     * 将链表按奇偶位置拆开
     * 然后奇相连，偶相连
     * 再把奇偶相连
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 奇链表从第一个节点开始
        ListNode first = head;
        // 偶链表从第二个节点开始
        ListNode second = head.next;
        // 保存偶链表的头结点，以便后面奇偶相连
        ListNode secondHead = second;
        while (second != null && second.next != null) {
            // 获得奇链表的下一个节点
            ListNode firstNext = second.next;
            // 获得偶链表的下一个节点
            ListNode secondNext = firstNext.next;

            // 奇链表连接下一个节点
            first.next = firstNext;
            // 跳到下一个节点
            first = first.next;

            // 偶链表连接下一个节点
            second.next = secondNext;
            // 跳到下一个节点
            second = second.next;
        }

        // 奇偶链表相连
        first.next = secondHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode n1 = h1;
        n1.next = new ListNode(2);
        n1 = n1.next;
        n1.next = new ListNode(3);
        n1 = n1.next;
        n1.next = new ListNode(4);
        n1 = n1.next;
        n1.next = new ListNode(5);

        PrintUtils.print(h1);

        ListNode h2 = oddEvenList(h1);
        PrintUtils.print(h2);
    }
}
