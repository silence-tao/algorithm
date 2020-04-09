package com.silentao.algorithms.sort;

/**
 * @Description 归并排序(自顶向下)
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 15:44
 **/
public class MergeSortDown extends MergeSort {

    @Override
    protected void sortExecute(int[] arr) {
        mergeSortDown(arr, 0, length - 1);
    }

    @Override
    protected String sortName() {
        return "归并排序(自顶向下)";
    }

    /**
     * 分组
     * @param arr
     * @param l
     * @param r
     */
    private void mergeSortDown(int[] arr, int l, int r) {
        // l >= r时表示无法再分组
        if (l >= r) {
            return ;
        }

        // 将数组分成两组
        int mid = l + (r - l) / 2;
        // 对分出来的分组继续分组
        mergeSortDown(arr, l, mid);
        mergeSortDown(arr, mid + 1, r);

        // 因为经过上面两次递归后从l-mid，从mid+1-r都是有序的
        // 所以只有当arr[mid] < arr[mid + 1]时，从r-l都是有序的，
        // 此时不需要再进行合并
        // 而当arr[mid] > arr[mid + 1]时，再进行归并
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }
}
