package com.silentao.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 166. 分数到小数
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * @Author Silence
 * @Date 2020/4/24 22:46
 **/
public class FractionRecurringDecimal {

    /**
     * 此题难点在于如何处理循环小数的情况
     * 根据除法规则
     * 在不断的进行除法运算时，如果除数在之前出现过
     * 那么就会出现循环小数
     * 这里用map记录出现过的除数和除数运算结果之前结果的长度
     * Map<除数, 结果的长度>
     * 当出现相同除数时表示出现了循环小数
     * 此时可以根据结果的长度插入"()"
     * @param numerator
     * @param denominator
     * @return
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        // 分母为0，直接返回
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        // 负负得正，这里用异或，其中一个为负就是负
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }

        // 转为long是为了避免-2147483648溢出
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        // 先将正数部分算出
        res.append(dividend / divisor);
        // 算出余数
        long num = dividend % divisor;

        // 余数为0表示整除直接返回
        if (num == 0) {
            return res.toString();
        }

        res.append(".");
        // 用map记录除数和当前结果长度
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            // 如果除数出现过，则插入()然后break
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");

                break ;
            }

            // 记录除数和当前结果长度
            // 此处记录的是当前计算之前的长度
            // 目的是为了插入(
            map.put(num, res.length());
            // 运算
            num *= 10;
            res.append(num / divisor);
            num %= denominator;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println(-50 / 8.0);
    }
}
