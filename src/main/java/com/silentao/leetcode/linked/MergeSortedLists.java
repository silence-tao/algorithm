package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 时间复杂度分析：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
 * @Author Silence
 * @Date 2020/6/28 22:16
 **/
public class MergeSortedLists {

    /**
     * 将所有链表都合并到第一个链表中
     * 时间复制度：O(k^2n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len;
        if (lists == null || (len = lists.length) == 0) {
            return null;
        }

        ListNode node = lists[0];
        // 遍历lists将所有链表都合并得到第一个链表中
        for (int i = 1; i < len; i++) {
            node = merge(node, lists[i]);
        }

        return node;
    }

    /**
     * 归并思路
     * 利用队列实现自底向上的归并
     * 先将数组中的链表两两合并，结果放到队列中
     * 然后遍历队列，每次poll两个链表合并再结果放到队列中
     * 直到队列中只剩下一个链表时，返回这一个链表
     * @param lists
     * @return
     */
    public static ListNode mergeLinkedList2(ListNode[] lists) {
        int len;
        if (lists == null || (len = lists.length) == 0) {
            return null;
        }

        Queue<ListNode> queue = new LinkedList<>();
        // 先将链表两两合并，结果放入队列中
        for (int i = 0; i < len;) {
            if (i + 1 < len) {
                queue.add(merge(lists[i], lists[i + 1]));
                i += 2;
            } else {
                queue.add(lists[i]);
                i++;
            }
        }

        // 遍历队列，每次弹出两个链表，合并再放入队列中
        // 队列只剩下一个链表时，结束循环
        while (queue.size() > 1) {
            ListNode node1 = queue.poll();
            ListNode node2 = queue.poll();

            queue.add(merge(node1, node2));
        }

        // 队列中剩下的这个链表，就是最好合并的链表
        return queue.poll();
    }

    /**
     * 合并两个单链表
     * @param h1
     * @param h2
     * @return
     */
    private static ListNode merge(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (h1 != null || h2 != null) {
            if (h1 == null) {
                // h1为空，直接把h2接到链表后面就可以break了
                node.next = h2;

                break ;
            } else if (h2 == null) {
                // h2为空，直接把h1接到链表后面就可以break了
                node.next = h1;

                break ;
            } else if (h1.val < h2.val) {
                node.next = h1;
                node = node.next;
                h1 = h1.next;
            } else {
                node.next = h2;
                node = node.next;
                h2 = h2.next;
            }
        }

        return head.next;
    }
}
