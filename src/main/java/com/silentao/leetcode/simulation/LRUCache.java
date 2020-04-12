package com.silentao.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * 利用map和双向链表实现LRU算法
 * @Author Silence
 * @Date 2020/4/12 21:34
 **/
public class LRUCache {

    private int capacity;

    private int size;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        // 首尾连接
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        // 不存在返回-1
        if (node == null) {
            return -1;
        }

        // 存在则将节点移动到头节点的位置
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            // 满了就删除掉最后一个节点
            if (size == capacity) {
                map.remove(tail.pre.key);

                remove(tail.pre);
            }

            node = new Node(key, value);
            map.put(key, node);

            addFirst(node);
        }
    }

    /**
     * 链表头部添加节点
     * @param node
     */
    private void addFirst(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    /**
     * 删除节点
     * @param node
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;

        node.pre = null;
        node.next = null;
    }

    /**
     * 将node移动到头节点
     * @param node
     */
    private void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private static class Node {
        private Node pre;
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    public static void printNode(Node node) {
        System.out.println("-----------");
        while (node != null) {
            System.out.println(node.key + ": " + node.value);

            node = node.next;
        }
        System.out.println("-----------");
    }
}
