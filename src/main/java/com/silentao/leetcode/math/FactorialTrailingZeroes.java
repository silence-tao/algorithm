package com.silentao.leetcode.math;

/**
 * @Description
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @Author Silence
 * @Date 2020/4/28 23:35
 **/
public class FactorialTrailingZeroes {

    /**
     * 要算阶乘后面有几个零
     * 把阶乘拆成质数因子
     * 然后算出5的个数即可
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
