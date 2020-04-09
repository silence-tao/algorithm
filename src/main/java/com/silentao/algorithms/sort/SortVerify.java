package com.silentao.algorithms.sort;

/**
 * @Description
 * @Author chentao10
 * @Date 2019/6/16 10:23
 **/
public class SortVerify {

    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 5, 3, 4, 7, 6, 0, 8};

        Sort selectionSort = new SelectionSort();
        selectionSort.sortVerify(arr);

        Sort insertionSort = new InsertionSort();
        insertionSort.sortVerify(arr);

        Sort bubbleSort = new BubbleSort();
        bubbleSort.sortVerify(arr);

        Sort shellSort = new ShellSort();
        shellSort.sortVerify(arr);

        Sort mergeSortDown = new MergeSortDown();
        mergeSortDown.sortVerify(arr);

        Sort mergeSortUp = new MergeSortUp();
        mergeSortUp.sortVerify(arr);

        Sort quickSortSingleWay = new QuickSortSingleWay();
        quickSortSingleWay.sortVerify(arr);

        Sort quickSortDoubleWay = new QuickSortDoubleWay();
        quickSortDoubleWay.sortVerify(arr);

        Sort quickSortTripleWay = new QuickSortTripleWay();
        quickSortTripleWay.sortVerify(arr);
    }
}
