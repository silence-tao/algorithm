package com.silentao.algorithms.sort;

/**
 * @Description 三路快排
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 16:46
 **/
public class QuickSortTripleWay extends QuickSort {

    @Override
    protected void sortExecute(int[] arr) {
        quickSort(arr, 0, length - 1);
    }

    @Override
    protected String sortName() {
        return "三路快排";
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return ;
        }

        int e = arr[l];

        // arr[l+1...lt]<v
        int lt = l;
        // arr[gt...r]>v
        int gt = r + 1;
        // arr[lt + 1...i]==v
        int i = l + 1;

        // 将小于e的元素放在e的左边
        // 将大于e的元素放在e的右边
        // 将等于e的元素放在中间
        while (i < gt) {
            if (arr[i] < e) {
                swap(arr, i++, ++lt);
            } else if (arr[i] > e) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        // 以e为基点将数组分为两组
        // 小于e的为一组
        // 大于e的为一组
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }
}
