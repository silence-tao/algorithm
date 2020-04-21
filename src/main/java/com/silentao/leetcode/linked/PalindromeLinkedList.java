package com.silentao.leetcode.linked;

import com.silentao.structures.linked.ListNode;
import com.silentao.util.PrintUtils;

import java.util.Stack;

/**
 * @Description
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Author Silence
 * @Date 2020/4/22 0:25
 **/
public class PalindromeLinkedList {

    /**
     * 利用栈保存前半部分节点值
     * 再和后半部分节点值相比较
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 将链表中前半部分节点值放在栈中
        Stack<Integer> stack = new Stack<>();
        // 利用快慢指针寻找中点
        ListNode slow, fast = slow = head;
        // 快指针是否遍历完，快指针遍历完说明慢指针已到达终点位置
        boolean fastEnd = false;
        while (slow != null) {
            // 链表有偶数个节点
            if (!fastEnd && fast == null) {
                fastEnd = true;
            }

            // 链表有奇数个节点
            if (!fastEnd && fast.next == null) {
                fastEnd = true;
                // 奇数个节点时，中点不需要比较，所以跳过
                slow = slow.next;
            }

            if (fastEnd && slow.val != stack.pop()) {
                // 快指针遍历完
                // 将链表后半部分的节点值与前半部分的节点值相比较
                // 不相等直接返回false
                return false;
            }

            if (!fastEnd) {
                // 快指针未遍历完
                // 就将节点值放入栈中
                // 快指针走两步
                stack.push(slow.val);
                fast = fast.next.next;
            }

            // 慢指针走一步
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode n1 = h1;
        n1.next = new ListNode(2);
        n1 = n1.next;
        n1.next = new ListNode(3);
        n1 = n1.next;
        n1.next = new ListNode(2);
        n1 = n1.next;
        n1.next = new ListNode(3);

        PrintUtils.print(h1);
        System.out.println(isPalindrome(h1));
    }
}
