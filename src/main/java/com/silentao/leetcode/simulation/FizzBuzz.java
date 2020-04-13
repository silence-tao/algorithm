package com.silentao.leetcode.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 412. Fizz Buzz
 * https://leetcode-cn.com/problems/fizz-buzz/
 * @Author Silence
 * @Date 2020/4/13 23:05
 **/
public class FizzBuzz {

    /**
     * 直接暴力解
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }

        return res;
    }
}
