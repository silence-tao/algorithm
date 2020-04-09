package com.silentao.algorithms.sort;

/**
 * @Description 希尔排序
 * 时间复杂度:o(n^4/3)
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 14:45
 **/
public class ShellSort extends Sort {

    @Override
    protected void sortExecute(int[] arr) {
        // 希尔排序是插入排序的升级版
        // 在插入排序里添加了一个增量
        // 以增量为gap的元素为一组进行插入排序
        int gap = length;
        // 通过不断缩小增量
        // 直到增量等于1位置
        while ((gap = gap / 2) > 0) {
            for (int i = gap; i < length; i += gap) {
                int e = arr[i];
                int j = i;
                for (; j > 0 && e < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = e;
            }
        }
    }

    @Override
    protected String sortName() {
        return "希尔排序";
    }
}
