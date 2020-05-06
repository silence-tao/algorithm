package com.silentao.leetcode.math;

/**
 * @Description
 * 326. 3的幂
 * https://leetcode-cn.com/problems/power-of-three/
 * @Author Silence
 * @Date 2020/5/6 23:14
 **/
public class PowerThree {

    public static boolean isPowerOfThree(int n) {
        while (n >= 3 && n % 3 == 0) {
            n /= 3;
        }

        if (n == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }
}
