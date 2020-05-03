package com.silentao.leetcode.math;

/**
 * @Description
 * 190. 颠倒二进制位
 * https://leetcode-cn.com/problems/reverse-bits/
 * @Author Silence
 * @Date 2020/5/3 22:32
 **/
public class ReverseBits {

    /**
     * 取当前 n 的最后一位：n & 1
     * 将最后一位移动到对应位置，第一次为 31 位，第二次是 30 位，即：31、30、29... 1、0，写作代码 bit << 31;
     * 退出条件，二进制反转时，如果剩余位数全位 0，则可以不用再反转。
     * @return
     */
    public static int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
