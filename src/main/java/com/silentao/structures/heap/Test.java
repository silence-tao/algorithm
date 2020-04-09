package com.silentao.structures.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author chentao10
 * @Date 2018/8/28 13:38
 **/
public class Test {

    private static final int SIZE = 100000;
    private static final int PRINT_MIN_SIZE = 20;

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        int side = 1000;
        if (SIZE > side) {
            side = SIZE;
        }

        for (int i = 0; i < SIZE; i++) {
            integers.add(random.nextInt(side));
        }

        test1(integers);

        System.out.println();

        test2(integers);

        System.out.println();

//        test3(integers);
    }

    public static void test1(List<Integer> integers) {
        if (integers.size() <= PRINT_MIN_SIZE) {
            System.out.println("test1:" + integers);
        }

        long startTime = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(integers.size());
        maxHeap.insert(integers);

        long endTime = System.currentTimeMillis();
        System.out.println("insert:" + integers.size() + ", time:" + (endTime - startTime) / 1000.0 + "s");

        if (integers.size() <= PRINT_MIN_SIZE) {
            System.out.println("maxHeap:" + maxHeap);

            List<Integer> sortList = maxHeap.sort();
            System.out.println("after sort:" + sortList);
        }
    }

    public static void test2(List<Integer> integers) {
        if (integers.size() <= PRINT_MIN_SIZE) {
            System.out.println("test2:" + integers);
        }

        Integer[] elements = new Integer[integers.size()];

        integers.toArray(elements);

        long startTime = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(elements);

        long endTime = System.currentTimeMillis();
        System.out.println("heapify:" + integers.size() + ", time:" + (endTime - startTime) / 1000.0 + "s");

        if (integers.size() <= PRINT_MIN_SIZE) {
            System.out.println("maxHeap:" + maxHeap);

            List<Integer> sortList = maxHeap.sort();
            System.out.println("after sort:" + sortList);
        }
    }

    public static void test3(List<Integer> integers) {
        if (integers.size() <= PRINT_MIN_SIZE) {
            System.out.println("test3:" + integers);
        }

        List<Integer> sortList = MaxHeap.heapSort(integers);
        System.out.println(sortList);
    }
}
