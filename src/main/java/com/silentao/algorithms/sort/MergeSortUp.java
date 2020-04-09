package com.silentao.algorithms.sort;

/**
 * @Description
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 15:47
 **/
public class MergeSortUp extends MergeSort {

    @Override
    protected void sortExecute(int[] arr) {
        // 从左到右依次将数组分成小段
        // 然后进行归并排序
        // 将分段的长度逐渐增大
        // 直到分段长度为数组的长度
        for (int sz = 1; sz <= length - 1; sz += sz) {
            for (int i = 0; i + sz <= length - 1; i += sz + sz) {
                if (arr[i + sz - 1] > arr[i + sz]) {
                    // 对arr[i...i+sz-1]和arr[i+sz...i+2*sz-1]进行归并
                    merge(arr, i, i + sz - 1,
                            Math.min(i + sz + sz - 1, length - 1));
                }
            }
        }
    }

    @Override
    protected String sortName() {
        return "归并排序(自底向上)";
    }
}
