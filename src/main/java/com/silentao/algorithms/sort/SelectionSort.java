package com.silentao.algorithms.sort;

/**
 * @Description 选择排序
 * 时间复杂度:o(n^2)
 * @Author chentao10
 * @Date 2019/6/16 10:23
 **/
public class SelectionSort extends Sort {

	@Override
	public void sortExecute(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			// 从当前元素向后查找出比当前元素还小的元素
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// 与当前元素交换
			swap(arr, i, minIndex);
		}
	}

	@Override
	protected String sortName() {
		return "选择排序";
	}
}
