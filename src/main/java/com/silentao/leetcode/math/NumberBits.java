package com.silentao.leetcode.math;

/**
 * @Description
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * @Author Silence
 * @Date 2020/5/6 21:49
 **/
public class NumberBits {

    /**
     * 每位和1做与运算
     * 然后无符号右移
     * 重复32次
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
