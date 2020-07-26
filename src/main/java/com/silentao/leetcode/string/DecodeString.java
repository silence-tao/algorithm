package com.silentao.leetcode.string;

/**
 * @Description
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @Author Silence
 * @Date 2020/7/22 7:26
 **/
public class DecodeString {

    private static int pos = 0;
    public static String decodeString(String s) {
        pos = 0;
        return helper(s);
    }

    private static String helper(String s) {
        StringBuilder res = new StringBuilder();
        int time = 0;
        for (; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            if (c == '[') {
                pos++;
                String str = helper(s);

                for (int i = 1; i <= time; i++) {
                    res.append(str);
                }

                time = 0;

                continue ;
            }

            if (c == ']') {
                break ;
            }

            if (c >= '0' && c <= '9') {
                time = time * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
