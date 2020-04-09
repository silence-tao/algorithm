package com.silentao.algorithms.sort;

/**
 * @Description 双路快排
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 16:34
 **/
public class QuickSortDoubleWay extends QuickSort {

    @Override
    protected void sortExecute(int[] arr) {
        quickSort(arr, 0, length - 1);
    }

    @Override
    protected String sortName() {
        return "双路快排";
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

        // 从两头开工
        // 将小于e的元素放在e的左边
        // 将大于e的元素放在e的右边
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < e) {
                i++;
            }

            while (j >= l && arr[j] > e) {
                j--;
            }

            if (i > j) {
                break ;
            }

            swap(arr, i++, j--);
        }

        swap(arr, l, j);

        return j;
    }
}
