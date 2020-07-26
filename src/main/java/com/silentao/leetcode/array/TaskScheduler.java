package com.silentao.leetcode.array;

import java.util.Arrays;

/**
 * @Description
 * 621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 * @Author Silence
 * @Date 2020/7/21 8:14
 **/
public class TaskScheduler {

    /**
     * 先将任务数统计出来，放在整型数组works里
     * 然后升序排序，每次执行n + 1个任务，即每次以执行n + 1个任务为1轮
     * 题解：https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] works = new int[26];
        for (char c : tasks) {
            works[c - 'A']++;
        }

        Arrays.sort(works);
        int times = 0;
        while (works[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (works[25] == 0) {
                    break ;
                }

                if (i < 26 && works[25 - i] > 0) {
                    works[25 - i]--;
                }

                times++;
                i++;
            }

            Arrays.sort(works);
        }

        return times;
    }
}
