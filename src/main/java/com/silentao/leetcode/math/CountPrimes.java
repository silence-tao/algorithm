package com.silentao.leetcode.math;

/**
 * @Description
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 * @Author Silence
 * @Date 2020/5/6 21:56
 **/
public class CountPrimes {

    /**
     * Sieve of Eratosthenes算法
     * 用一个bool类型的数组保存是否为质数
     * 从2开始，每个数的整数倍都不是质数
     * 遍历到sqrt(n)即可
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            // 将所有数都标记为true
            isPrimes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    // 将非质数标记为false
                    isPrimes[j] = false;
                }
            }
        }

        int res = 0;
        // 统计质数的个数
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                res++;
            }
        }

        return res;
    }
}
