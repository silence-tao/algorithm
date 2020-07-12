package com.silentao.leetcode.stack;

import java.util.Stack;

/**
 * @Description
 * 227. 基本计算器 II
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * @Author Silence
 * @Date 2020/6/13 17:43
 **/
public class BasicCalculator {

    /**
     * 1、先给第一个数字加一个默认符号+，变成+1-12+3；
     * 2、把一个运算符和数字组合成一对儿，也就是三对儿+1，-12，+3，
     * 把它们转化成数字，然后放到一个栈中；
     * 3、将栈中所有的数字求和，就是原算式的结果；
     * 4、如果遇到乘除，就先和上一个数先做运算然后再入栈
     * @param s
     * @return
     */
    public static int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }

        Stack<Integer> number = new Stack<>();

        // 保存当前数字左边的运算符
        char symbol = '+';
        // 保存当前遍历的数字
        int num = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (isDigital(ch)) {
                // 如果是数字就和之前的数字结合
                num = num * 10 + (ch - '0');
            }

            if ((!isDigital(ch) && ch != ' ') || i + 1 == len) {
                // 到了这里说ch是运算符或者是最后一个字符
                if (symbol == '+') {
                    // 如果当前数左边是加号直接入栈
                    number.push(num);
                } else if (symbol == '-') {
                    // 如果当前数左边是减号号变负再入栈
                    number.push(-num);
                } else if (symbol == '*') {
                    // 如果当前数左边是乘号就将当前数与前一个数的运算结果入栈
                    number.push(number.pop() * num);
                } else if (symbol == '/') {
                    // 如果当前数左边是除号就将当前数与前一个数的运算结果入栈
                    number.push(number.pop() / num);
                }

                // 记录下一个运算符
                symbol = ch;
                num = 0;
            }
        }

        int res = 0;
        while (!number.isEmpty()) {
            res += number.pop();
        }

        return res;
    }

    /**
     * 判断字符c是否为数字
     * @param c
     * @return
     */
    private static boolean isDigital(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }

    /**
     * 带括号的运算
     * @param s
     * @return
     */
    public static int calculateWithBrackets(String s) {
        return calculateWithBrackets(s, s.length());
    }

    /**
     * 遍历s的全局位置
     */
    private static int pos = 0;

    /**
     * 递归计算
     * 遇到()就递归
     * 把括号里的算式当成是一个数字
     * @param s
     * @param len
     * @return
     */
    private static int calculateWithBrackets(String s, int len) {
        Stack<Integer> number = new Stack<>();

        char symbol = '+';
        int num = 0;

        for (; pos < len; pos++) {
            char c = s.charAt(pos);

            if (isDigital(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!isDigital(c) && c != ' ') || pos + 1 == len) {
                if (c == '(') {
                    // 跳过'('
                    pos++;
                    // 计算括号表达式里的值
                    num = calculateWithBrackets(s, len);
                    // 跳过')'
                    pos++;
                }

                if (symbol == '+') {
                    number.push(num);
                } else if (symbol == '-') {
                    number.push(-num);
                } else if (symbol == '*') {
                    number.push(number.pop() * num);
                } else if (symbol == '/') {
                    number.push(number.pop() / num);
                }

                symbol = c;
                num = 0;

                // 遇到'('表示括号表达式结束，跳出循环
                if (c == ')') {
                    break ;
                }
            }
        }

        int res = 0;
        while (!number.isEmpty()) {
            res += number.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculateWithBrackets(" 4 * ( 2 * (9 - 8) + 4 ) + 1 + 2 * (3 - 1) * 2"));
    }
}
