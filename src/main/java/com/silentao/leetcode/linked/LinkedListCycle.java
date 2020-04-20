package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;

/**
 * @Description
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @Author Silence
 * @Date 2020/4/21 0:02
 **/
public class LinkedListCycle {

    /**
     * 利用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
