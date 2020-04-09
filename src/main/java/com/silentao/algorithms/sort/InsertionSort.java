package com.silentao.algorithms.sort;

/**
 * @Description 插入排序
 * 时间复杂度:O(nlogn)
 * @Author 米兰半岛铁盒
 * @Date 2019/6/16 13:32
 **/
public class InsertionSort extends Sort {

    @Override
    protected void sortExecute(int[] arr) {
        // 后面的元素和前面的每个元素比较
        // 找到合适的位置
        // 并插入到其中
        for (int i = 1; i < length; i++) {
            // 默认第一个元素是有序的
            // 所以这里i从1开始
            int e = arr[i];
            int j = i;
            // 从第i个元素向前遍历
            // 如果元素e小于j-1位置的元素
            // 则元素j-1位置的元素后移一个位置
            // 然后j--
            // 如果j <= 0或者e > arr[j - 1]
            // 那么表示e要大于j位置以前的元素
            // 且e要小于j位置以后的元素
            // 此时j就是e的位置
            for (; j > 0 && e < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }

            // 将e放到j的位置上
            arr[j] = e;
        }
    }

    @Override
    protected String sortName() {
        return "插入排序";
    }
}
