package com.silentao.algorithms.sort;

/**
 * @Description 冒泡排序
 * 时间复杂度:O(n^2)
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 14:33
 **/
public class BubbleSort extends Sort {

    @Override
    protected void sortExecute(int[] arr) {
        for (int i = 0; i < length; i++) {
            // 相邻的元素两两比较
            // 反序则交换位置
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    swap(arr, j, j + 1);
                }
            }

            if (flag) {
                break ;
            }
        }
    }

    @Override
    protected String sortName() {
        return "冒泡排序";
    }
}
