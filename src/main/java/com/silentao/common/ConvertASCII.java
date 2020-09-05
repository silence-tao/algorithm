package com.silentao.common;

import java.util.Stack;

/**
 * @Description
 * 实现把一个长整型数字编码为ASCII码字符串（128进制）
 * 实现另一个方法把ASCII字符串（128进制）解码为long
 * @Author Silence
 * @Date 2020/8/12 22:08
 **/
public class ConvertASCII {

    /**
     * 实现把一个长整型数字编码为ASCII码字符串（128进制）
     * @param l
     * @return
     */
    public static String convertLong2ASCIIString(long l) {
        Stack<Integer> stack = new Stack<>();

        long num = l;
        while (num != 0) {
            stack.push((int) num % 128);

            num /= 128;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            int item = stack.pop();

            char c = (char) item;

            builder.append(c);
        }

        return builder.toString();
    }

    /**
     * 实现另一个方法把ASCII字符串（128进制）解码为long
     * @param s
     * @return
     */
    public static long convertASCIIString2Long(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0L;
        }

        long res = 0L, num = 1;
        for (int i = len - 1; i >= 0; i--) {
            int item = s.charAt(i);

            if (i != len - 1) {
                num *= 128;
            }

            res += num * item;
        }

        return res;
    }

    public static void main(String[] args) {
        long num = 2134354546L;
        String res = convertLong2ASCIIString(num);
        System.out.println(res);

        long ans;
        System.out.println(ans = convertASCIIString2Long(res));

        System.out.println(num == ans);

        String s = "chen";
        num = convertASCIIString2Long(s);
        System.out.println(num);

        System.out.println(res = convertLong2ASCIIString(num));

        System.out.println(s.equals(res));
    }
}
