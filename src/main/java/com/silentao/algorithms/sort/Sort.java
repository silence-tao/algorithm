package com.silentao.algorithms.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @Description
 * @Author chentao10
 * @Date 2019/6/16 10:21
 **/
public abstract class Sort {

    protected int length;

    /**
     * 排序
     * @param arr
     */
    public void sort(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            System.out.println("排序数组为空");

            return ;
        }

        this.length = arr.length;
        sortExecute(arr);
    }

    public void sortVerify(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            System.out.println("排序数组为空");

            return ;
        }

        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            sortArr[i] = arr[i];
        }

        System.out.println(sortName());

        System.out.println("排序前:");
        show(sortArr);

        sort(sortArr);

        System.out.println("排序结果:");
        show(sortArr);
        System.out.println();
    }

    /**
     * 打印数组
     * @param arr
     */
    public void show(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            System.out.println("数组为空");

            return ;
        }

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    /**
     * 交换数组两个位置的元素
     * @param arr
     * @param i
     * @param j
     */
    protected void swap(int[] arr, int i, int j) {
        if (ArrayUtils.isEmpty(arr) || i < 0 || j < 0 ||
            i > arr.length || j > arr.length || i == j) {
            return ;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 排序逻辑
     * @param arr
     */
    protected abstract void sortExecute(int[] arr);

    /**
     * 排序算法名称
     * @return
     */
    protected abstract String sortName();
}
