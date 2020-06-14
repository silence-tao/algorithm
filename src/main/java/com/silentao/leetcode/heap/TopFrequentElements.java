package com.silentao.leetcode.heap;

import java.util.*;

/**
 * @Description 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Author Silence
 * @Date 2020/6/13 15:43
 **/
public class TopFrequentElements {

    /**
     * 使用map保持元素与出现频率的映射
     * 按元素出现频率维护一个最小堆
     * 保持堆中只有k个元素
     * 这k个元素就是前 K 个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.remove();
        }

        return res;
    }

    /**
     * // 遍历map，用最小堆保存频率最大的k个元素
     *         PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
     *             @Override
     *             public int compare(Integer a, Integer b) {
     *                 return map.get(a) - map.get(b);
     *             }
     *         });
     *         for (Integer key : map.keySet()) {
     *             if (pq.size() < k) {
     *                 pq.add(key);
     *             } else if (map.get(key) > map.get(pq.peek())) {
     *                 pq.remove();
     *                 pq.add(key);
     *             }
     *         }
     *         // 取出最小堆中的元素
     *         List<Integer> res = new ArrayList<>();
     *         while (!pq.isEmpty()) {
     *             res.add(pq.remove());
     *         }
     *         return res;
     */
}
