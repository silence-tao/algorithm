package com.silentao.algorithms.sort;

/**
 * @Description 归并排序
 * 时间复杂度:O(nlogn)
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 15:10
 **/
public abstract class MergeSort extends Sort {

    /**
     * 归并
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    protected void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
