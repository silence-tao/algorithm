package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;
import com.silentao.util.PrintUtils;

/**
 * @Description
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * @Author Silence
 * @Date 2020/4/21 23:16
 **/
public class SortList {

    /**
     * 利用归并排序可以实现O(nlogn)复杂度的排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow, fast = slow = head;
        // 利用快慢指针找到中点位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        slow = slow.next;
        // 将链表切开
        pre.next = null;

        // 分别做归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 合并两条链表
        return merge(left, right);
    }

    /**
     * 合并有序链表
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        ListNode res = new ListNode(0);
        ListNode node = res;
        while (left != null || right != null) {
            if (left == null) {
                node.next = right;

                break ;
            } else if (right == null) {
                node.next = left;

                break ;
            } else if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }

            node = node.next;
        }

        return res.next;
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

        ListNode h2 = new ListNode(2);
        ListNode n2 = h2;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(6);
        n2 = n2.next;
        n2.next = new ListNode(8);
        n2 = n2.next;
        n2.next = new ListNode(10);

        PrintUtils.print(h2);

        ListNode h = merge(h1, h2);
        PrintUtils.print(h);

        ListNode sort = sortList(h);
        PrintUtils.print(sort);
    }
}
