package com.silentao.leetcode.heap;

/**
 * @Description 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Author Silence
 * @Date 2020/6/13 15:10
 **/
public class SmallestElementInSortedMatrix {

    /**
     * 找最小用最大堆
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int size = 0;
        // 大小为k + 1的最大堆
        int[] heap = new int[k + 1];

        // 将nums中的元素逐个添加到堆中
        // 并维持堆中只有k个元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                heap[size++] = matrix[i][j];
                shiftUp(heap, size - 1);

                if (size > k) {
                    swap(heap, 0, --size);

                    shiftDown(heap, 0, size);
                }
            }
        }

        return heap[0];
    }

    /**
     * 自下而上维护最大堆的性质
     * @param heap
     * @param i
     */
    private void shiftUp(int[] heap, int i) {
        int head;
        while (i > 0 && heap[head = (i - 1) / 2] < heap[i]) {
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
            if (j + 1 < size && heap[j] < heap[j + 1]) {
                j = j + 1;
            }

            if (heap[i] >= heap[j]) {
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
}
