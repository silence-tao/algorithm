package com.silentao.leetcode.stack;

import java.util.Stack;

/**
 * @Description 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * @Author Silence
 * @Date 2020/6/13 9:18
 **/
public class MinStack {

    /**
     * 用单链表实现栈
     */
    private static class MinStack1 {
        /**
         * 最小值
         */
        private int min;

        /**
         * 头结点
         */
        private Node head;

        /**
         * 尾节点
         */
        private Node tail;

        private class Node {
            Node pre;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }

        /** initialize your data structure here. */
        public MinStack1() {
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            // 更新最小值
            if (min > x) {
                min = x;
            }

            Node node = new Node(x);
            if (head == null) {
                head = node;
            }

            node.pre = tail;
            tail = node;
        }

        public void pop() {
            if (tail == null) {
                return ;
            }

            Node pre = tail.pre;

            // 更新最小值
            Node node = pre;
            int m = Integer.MAX_VALUE;
            while (node != null) {
                if (m > node.val) {
                    m = node.val;
                }

                node = node.pre;
            }

            min = m;

            tail.pre = null;
            tail = pre;
        }

        public int top() {
            return tail.val;
        }

        public int getMin() {
            return min;
        }
    }

    /**
     * 利用Stack来实现
     */
    private static class MinStack2 {

        private Stack<Integer> stack;

        /**
         * 存放最小最
         */
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack2() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

            if (minStack.isEmpty() || x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
