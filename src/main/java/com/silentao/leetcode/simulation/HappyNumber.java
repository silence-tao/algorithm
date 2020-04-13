package com.silentao.leetcode.simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * @Author Silence
 * @Date 2020/4/13 22:03
 **/
public class HappyNumber {

    /**
     * 暴力解法
     * 通过Set来记录已经出现过的数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> memory = new HashSet<>();

        while (n != 1) {
            if (memory.contains(n)) {
                return false;
            } else {
                memory.add(n);
            }

            int sum = 0;
            while (n != 0) {
                int t = n % 10;
                sum += t * t;

                n /= 10;
            }

            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
