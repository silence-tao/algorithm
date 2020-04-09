package com.silentao.algorithms.sort;

/**
 * @Description 单路快排
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 16:15
 **/
public class QuickSortSingleWay extends QuickSort {

    @Override
    protected void sortExecute(int[] arr) {
        quickSort(arr, 0, length - 1);
    }

    @Override
    protected String sortName() {
        return "单路快排";
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return ;
        }

        int p = partition(arr, l, r);
        // 以p为基点将数组分为两组
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 以数组中的第一个元素为基点
     * 找到元素排好序后的位置
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] arr, int l, int r) {
        int e = arr[l];

        // 将小于e的元素放在左边
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < e) {
                swap(arr, ++p, i);
            }
        }

        // 最后j就是e排好序后的位置
        swap(arr, l, p);

        return p;
    }
}
