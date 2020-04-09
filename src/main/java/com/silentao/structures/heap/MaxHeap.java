package com.silentao.structures.heap;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 最大堆
 * @Author Silence
 * @Date 2018/8/26 11:00
 **/
public class MaxHeap<T extends Comparable> implements Heap<T> {

    /**
     * 堆中的数据
     */
    protected T[] elements;

    /**
     * 堆当前存储数据的数量
     */
    protected int size;

    /**
     * 堆的容量
     */
    protected int capacity;

    public MaxHeap(int capacity) {
        this.elements = (T[]) new Comparable[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * heapify
     * @param elements
     */
    public MaxHeap(List<T> elements) {
        if (CollectionUtils.isNotEmpty(elements)) {
            int size = elements.size();
            this.elements = (T[]) new Comparable[size + 1];

            for (int i = 0; i < size; i++) {
                this.elements[i + 1] = elements.get(i);
            }

            this.size = size;
            this.capacity = size;

            for (int i = this.size / 2; i >= 1; i--) {
                shiftDown(i);
            }
        }
    }

    public MaxHeap(T[] elements) {
        if (null != elements && 0 != elements.length) {
            int size = elements.length;
            this.elements = (T[]) new Comparable[size + 1];

            for (int i = 0; i < size; i++) {
                this.elements[i + 1] = elements[i];
            }

            this.size = size;
            this.capacity = size;

            for (int i = this.size / 2; i >= 1; i--) {
                shiftDown(i);
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return this.size > 0;
    }

    @Override
    public void insert(T element) {
        if (this.capacity < this.size + 1) {
            System.out.println("数量超过了堆的容量");

            return ;
        }

        this.elements[++size] = element;
        shiftUp(size);
    }

    public void insert(List<T> elements) {
        if (null == elements || 0 == elements.size()) {
            System.out.println("集合不能为空");

            return ;
        }

        for (T element : elements) {
            this.elements[++size] = element;

            shiftUp(size);
        }
    }

    @Override
    public T extractMax() {
        if (this.size == 0) {
            return null;
        }

        T result = this.elements[1];

        swap(this.elements, 1, this.size);

        this.size--;

        shiftDown(1);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 1; i <= this.size; i++) {
            stringBuilder.append(this.elements[i]);

            if (i != this.size) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    @Override
    public List<T> sort() {
        if (0 == this.size) {
            return null;
        }

        List<T> sortList = new ArrayList<>();
        for (int i = this.size; i >= 1; i--) {
            sortList.add(this.extractMax());
        }

        return sortList;
    }

    /**
     * shift up
     * 自底向上比较元素大小，找到合适的位置
     * @param k
     */
    protected void shiftUp(int k) {
        while (k > 1 && elements[k / 2].compareTo(elements[k]) < 0) {
            swap(elements, k / 2, k);

            k = k / 2;
        }
    }

    /**
     * shift down
     * 自顶向下比较元素大小，找到合适的位置
     * @param k
     */
    protected void shiftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && elements[j + 1].compareTo(elements[j]) > 0) {
                j += 1;
            }

            if (elements[k].compareTo(elements[j]) >= 0) {
                break ;
            }

            swap(elements, k, j);
            k = j;
        }
    }

    /**
     * 交换数组中元素a,b的位置
     * @param arr
     * @param a
     * @param b
     */
    protected static <E> void swap(E arr[], int a, int b) {
        if (null == arr || a >= arr.length || b >= arr.length) {
            System.out.println("index is more than capacity");

            return ;
        }

        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static <E extends Comparable> void shiftDown(E arr[], int size, int k) {
        while (2 * k + 1 < size) {
            int j = 2 * k + 1;
            if (j + 1 < size && arr[j + 1].compareTo(arr[j]) > 0) {
                j += 1;
            }

            if (arr[k].compareTo(arr[j]) > 0) {
                break ;
            }

            swap(arr, k, j);

            k = j;
        }
    }

    public static <E extends Comparable> List<E> heapSort(List<E> elements) {
        if (CollectionUtils.isEmpty(elements)) {
            return null;
        }

        int size = elements.size();
        E[] arr = (E[]) new Comparable[size];
        elements.toArray(arr);

        //heapify
        for (int i = (size - 1) / 2; i >= 0; i--) {
            shiftDown(arr, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }

        return Arrays.asList(arr);
    }
}
