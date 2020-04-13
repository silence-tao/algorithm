package com.silentao.leetcode.simulation;

/**
 * @Description
 * 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * @Author Silence
 * @Date 2020/4/13 22:48
 **/
public class SumOfTwoIntegers {

    /**
     * 十进制加法中，两数相加后就会得到低位和进位
     * 如：5+7低位是2，进位是1，进位*10+低位就是加法的结果
     * 如果还有进位则继续相加，直到进位为0为止
     * 二进制加法也是如此
     * 二进制低位：a ^ b
     * 二进制进位：a & b
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        // 低位
        int lower;
        // 进位
        int carrier;
        while (true) {
            lower = a ^ b;
            carrier = a & b;

            // 当进位为0时加法结束
            if (carrier == 0) {
                break ;
            }

            a = lower;
            b = carrier << 1;
        }

        return lower;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, -3));
    }
}
