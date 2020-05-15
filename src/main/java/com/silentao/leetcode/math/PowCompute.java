package com.silentao.leetcode.math;

/**
 * @Description
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @Author chentao10
 * @Date 2020/5/11 23:59
 **/
public class PowCompute {

    /**
     * 快速幂-迭代法
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long s = n;
        s = s > 0 ? s : -s;
        double res = 1, t = x;
        // 在对 s 进行二进制拆分的同时计算答案
        while (s > 0) {
            if (s % 2 == 1) {
                // 如果 s 二进制表示的最低位为 1，那么需要计入贡献
                res *= t;
            }

            // 将贡献不断地平方
            t *= t;
            // 舍弃 s 二进制表示的最低位，这样我们每次只要判断最低位即可
            s /= 2;
        }

        if (n < 0) {
            res = 1.0 / res;
        }

        return res;
    }

    public static void main(String[] args) {
        // 2 * 2
        // 2 * 2 * 2 * 2
        System.out.println(myPow(2, 2));
    }
}
