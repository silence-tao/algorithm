package com.silentao.leetcode.stack;

import java.util.Stack;

/**
 * @Description 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @Author Silence
 * @Date 2020/6/13 17:26
 **/
public class EvaluateReversePolishNotation {

    /**
     * 利用栈后进先出解决这道题
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        int len;
        if (tokens == null || (len = tokens.length) == 0) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            String str = tokens[i];
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());

                int res = 0;

                if ("+".equals(str)) {
                    res = a + b;
                }

                if ("-".equals(str)) {
                    res = a - b;
                }

                if ("*".equals(str)) {
                    res = a * b;
                }

                if ("/".equals(str)) {
                    res = a / b;
                }

                stack.push(Integer.toString(res));
            } else {
                stack.push(str);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[] {"4","13","5","/","+"};

        System.out.println(evalRPN(tokens));
    }
}
