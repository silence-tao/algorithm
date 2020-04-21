package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @Author Silence
 * @Date 2020/4/21 23:59
 **/
public class IntersectionTwoLinkedLists {

    /**
     * 使用集合保存其中一条链表的所有节点
     * 再去遍历另一条链表
     * 出现的第一个存在于集合中的节点就是相交的起始节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> memory = new HashSet<>();
        ListNode ha = headA;
        while (ha != null) {
            memory.add(ha);
            ha = ha.next;
        }

        ListNode hb = headB;
        while (hb != null) {
            if (memory.contains(hb)) {
                return hb;
            }

            hb = hb.next;
        }

        return null;
    }
}
