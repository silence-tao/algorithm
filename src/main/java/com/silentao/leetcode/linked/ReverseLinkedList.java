package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;
import com.silentao.util.PrintUtils;

/**
 * @Description
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @Author Silence
 * @Date 2020/4/22 0:06
 **/
public class ReverseLinkedList {

    /**
     * 迭代法反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = new ListNode(0);
        while (head != null) {
            ListNode tNode = head;
            head = head.next;

            tNode.next = res.next;
            res.next = tNode;
        }

        return res.next;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode res = reverseList2(next);
        head.next = next.next;
        next.next = head;

        return res;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        ListNode n1 = h1;
        n1.next = new ListNode(1);
        n1 = n1.next;
        n1.next = new ListNode(7);
        n1 = n1.next;
        n1.next = new ListNode(9);
        n1 = n1.next;
        n1.next = new ListNode(5);

        PrintUtils.print(h1);

        ListNode reverse = reverseList2(h1);
        PrintUtils.print(reverse);
    }
}
