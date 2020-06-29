package com.silentao.leetcode.queue;

import java.util.LinkedList;

/**
 * @Description
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 239. 滑动窗口最大值
 * @Author Silence
 * @Date 2020/6/29 21:39
 **/
public class SlidingWindowMaximum {

    /**
     * 利用双端队列维护一个单调递减队列
     * 保持队列头部元素最大，维护队列元素个数为k
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1) {
            return new int[0];
        }

        int[] res = new int[len - k + 1];
        int j = 0;

        // 用双端队列保存滑动窗口到元素
        // 并维持一个单调递减到队列
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                put(linkedList, nums[i]);
            } else {
                put(linkedList, nums[i]);
                res[j++] = linkedList.peekFirst();

                if (nums[i + 1 - k] == linkedList.peekFirst()) {
                    linkedList.pollFirst();
                }
            }
        }

        return res;
    }

    /**
     * 将元素添加到队列尾部
     * 并将队列中从尾部到头部元素小于num的元素删除
     * 保持队列头部就是滑动窗口最大到元素
     * @param linkedList
     * @param item
     */
    private void put(LinkedList<Integer> linkedList, int item) {
        while (!linkedList.isEmpty() && linkedList.peekLast() < item) {
            linkedList.pollLast();
        }

        linkedList.offerLast(item);
    }
}
