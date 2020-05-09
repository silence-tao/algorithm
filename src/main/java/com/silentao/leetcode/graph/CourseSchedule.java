package com.silentao.leetcode.graph;

import java.util.*;

/**
 * @Description
 * 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * @Author Silence
 * @Date 2020/5/9 22:26
 **/
public class CourseSchedule {

    /**
     * 广度优先遍历
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 每门课程需要学习先修课程的数量
        int[] need = new int[numCourses];
        // 先修课程和课程的对应关系
        List<List<Integer>> courses = new ArrayList<>();
        // 用队列来做广度优先遍历
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        // 统计没门课程需要学习的先修课程
        for (int[] cour : prerequisites) {
            need[cour[0]]++;
            courses.get(cour[1]).add(cour[0]);
        }

        // 将所有不需要先修课程的课程加入队列
        // 表示可以先学
        for (int i = 0; i < numCourses; i++) {
            if (need[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // 学习先修课程
            int pre = queue.poll();
            numCourses--;

            // 将把当前课程作为先修课程的课程遍历一下
            for (int c : courses.get(pre)) {
                // 需要的先修课程减1
                // 如果等于0表示课程需要的先修课程学完了
                if (--need[c] == 0) {
                    // 加入队列，表示可以学这门课程了
                    queue.add(c);
                }
            }
        }

        // 等于0表示课程学完了
        return numCourses == 0;
    }
}
