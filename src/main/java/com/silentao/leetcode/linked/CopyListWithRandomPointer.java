package com.silentao.leetcode.linked;

import com.silentao.structures.linked.Node;

/**
 * @Description
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @Author Silence
 * @Date 2020/4/20 22:50
 **/
public class CopyListWithRandomPointer {

    /**
     * 先把所有节点都复制一遍
     * 并把复制节点拼接在原节点后面
     * 把复制的节点取出来
     * 如果random节点不为空
     * 那么复制的random节点就应该指向原节点的random节点的next节点
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node copy = head;
        // 先把每个节点复制一遍
        // 每个节点next接的就是自己的副本
        while (copy != null) {
            Node node = new Node(copy.val);
            node.next = copy.next;
            copy.next = node;

            copy = copy.next.next;
        }

        copy = head;

        // 处理random节点
        while (copy != null) {
            // 当前接口的random节点不为空
            if (copy.random != null) {
                // 那么当前节点的副本的random节点将指向
                // 当前节点random节点的next
                copy.next.random = copy.random.next;
            }

            copy = copy.next.next;
        }

        Node res = new Node(0);
        Node next = res;
        copy = head;
        // 把复制的节点取出来
        while (copy != null) {
            // 指向当前节点的副本
            next.next = copy.next;
            // 跳到副本节点
            next = next.next;

            // next直接指向原来的下一个节点
            copy.next = next.next;
            // 跳到下一个节点
            copy = copy.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        Node node1 = new Node(13);
        head.next = node1;
        node1.random = head;
        Node node2 = new Node(11);
        node1.next = node2;
        Node node3 = new Node(10);
        node2.next = node3;
        Node node4 = new Node(1);
        node3.next = node4;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        printNode(head);
        System.out.println("--------------------");

        Node res = copyRandomList(head);
//        printNode(res);

        System.out.println("--------------------");

//        printNode(head);
    }

    private static void printNode(Node list) {
        Node head = list;
        while (head != null) {
            System.out.print("val : " + head.val);
            Node random = head.random;
            if (random != null) {
                System.out.print(", random : " + head.random.val);
            }

            head = head.next;
            if (head != null) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
