package com.silentao.leetcode.heap;

/**
 * @Description 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Author Silence
 * @Date 2020/6/13 13:10
 **/
public class LargestElementInArray {

    /**
     * 建立一个大小为k + 1的最小堆
     * 将nums的元素逐个添加到堆中
     * 当堆中元素大于k个时
     * 将堆顶元素删除
     * 保持堆中一直只有k个元素
     * parent = (sub - 1) / 2
     * left sub = parent * 2 + 1
     * right sub = parent * 2 + 2
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len;
        len = nums.length;

        int size = 0;
        // 大小为k + 1的最小堆
        int[] heap = new int[k + 1];

        // 将nums中的元素逐个添加到堆中
        // 并维持堆中只有k个元素
        for (int i = 0; i < len; i++) {
            heap[size++] = nums[i];
            shiftUp(heap, size - 1);

            if (size > k) {
                swap(heap, 0, --size);

                shiftDown(heap, 0, size);
            }
        }

        return heap[0];
    }

    /**
     * 自下而上维护最小堆的性质
     * @param heap
     * @param i
     */
    private void shiftUp(int[] heap, int i) {
        int head;
        while (i > 0 && heap[head = (i - 1) / 2] > heap[i]) {
            swap(heap, head, i);
            i = head;
        }
    }

    /**
     * 自上而下维护堆的性质
     * @param heap
     * @param i
     * @param size
     */
    private void shiftDown(int[] heap, int i, int size) {
        while (i * 2 + 1 < size) {
            int j = i * 2 + 1;
            if (j + 1 < size && heap[j] > heap[j + 1]) {
                j = j + 1;
            }

            if (heap[i] <= heap[j]) {
                break ;
            }

            swap(heap, i, j);
            i = j;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};

        LargestElementInArray element = new LargestElementInArray();
        System.out.println(element.findKthLargest(nums, 2));
    }
}