package com.silentao.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Author Silence
 * @Date 2020/7/27 8:00
 **/
public class LetterCombinationsPhoneNumber {

    private final static String[] LETTERS = new String[] {
            "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"
    };

    /**
     * 递归即可
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        StringBuilder builder = new StringBuilder();
        letterCombinations(digits, 0, builder, res);

        return res;
    }

    private static void letterCombinations(String digits, int pos, StringBuilder builder, List<String> res) {
        if (pos == digits.length()) {
            res.add(builder.toString());

            return ;
        }

        String letter = LETTERS[(digits.charAt(pos) - '0') - 2];
        for (int i = 0; i < letter.length(); i++) {
            builder.append(letter.charAt(i));
            letterCombinations(digits, pos + 1, builder, res);
            builder.delete(builder.length() - 1, builder.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
