package com.silentao.structures.heap;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Description
 * @Author chentao10
 * @Date 2018/9/5 14:05
 **/
public class IndexMaxHeap<T extends Comparable> {

    /**
     * 堆中的数据
     */
    private T[] elements;

    /**
     * 堆当前存储数据的数量
     */
    private int size;

    /**
     * 堆的容量
     */
    private int capacity;

    /**
     * 索引数组
     */
    private int[] indexes;

    public IndexMaxHeap(int capacity) {
        this.elements = (T[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * heapify
     * @param elements
     */
    public IndexMaxHeap(List<T> elements) {
        if (CollectionUtils.isNotEmpty(elements)) {
            int size = elements.size();
            this.elements = (T[]) new Comparable[size + 1];

            for (int i = 0; i < size; i++) {
                this.elements[i + 1] = elements.get(i);
                this.indexes[this.size + 1] = i + 1;

                this.size++;
            }

            this.capacity = size;

            for (int i = this.size / 2; i >= 1; i--) {
                shiftDown(i);
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size > 0;
    }

    /**
     * 插入一个元素
     * @param i
     * @param element
     */
    public void insert(int i, T element) {
        if (this.capacity < this.size + 1 ||
                i + 1 < 1 ||
                i + 1 > this.capacity) {
            System.out.println("数量超过了堆的容量");

            return ;
        }

        i += 1;
        this.elements[i] = element;
        this.indexes[this.size + 1] = i;

        this.size++;

        shiftUp(this.size);
    }

    public T extractMax() {
        if (this.size <= 0) {
            return null;
        }

        T result = this.elements[indexes[1]];

        swap(indexes, 1, this.size);

        this.size--;

        shiftDown(1);

        return result;
    }

    public int extractMaxIndex() {
        if (this.size <= 0) {
            return -1;
        }

        int result = indexes[1] - 1;

        swap(indexes, 1, this.size);

        this.size--;

        shiftDown(1);

        return result;
    }

    public T getElement(int i) {
        return this.elements[i];
    }

    public void change(int i, T element) {
        if (i < 0 ||
                i + 1 > this.capacity||
                null == element) {
            System.out.println("入参不合法");

            return ;
        }

        i += 1;

        this.elements[i] = element;

        //这里需要找到elements[i]在堆中的位置
        for (int j = 0; j < this.size; j++) {
            if (indexes[j] == i) {
                shiftUp(i);
                shiftDown(i);

                return ;
            }
        }
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

    /**
     * shift up
     * 自底向上比较元素大小，找到合适的位置
     * @param k
     */
    protected void shiftUp(int k) {
        while (k > 1 && elements[indexes[k / 2]].compareTo(elements[indexes[k]]) < 0) {
            swap(indexes, k / 2, k);

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
            if (j + 1 <= size && elements[indexes[j + 1]].compareTo(elements[indexes[j]]) > 0) {
                j += 1;
            }

            if (elements[indexes[k]].compareTo(elements[indexes[j]]) >= 0) {
                break ;
            }

            swap(indexes, k, j);
            k = j;
        }
    }

    /**
     * 交换数组中元素a,b的位置
     * @param arr
     * @param a
     * @param b
     */
    protected static void swap(int arr[], int a, int b) {
        if (null == arr || a >= arr.length || b >= arr.length) {
            System.out.println("index is more than capacity");

            return ;
        }

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
